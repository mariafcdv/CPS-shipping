package com.cdv.CPS.shipping.service;

import com.cdv.CPS.shipping.dto.QuoteRequest;
import com.cdv.CPS.shipping.dto.QuoteResponse;
import com.cdv.CPS.shipping.entity.Client_TypeEntity;
import com.cdv.CPS.shipping.entity.CountryEntity;
import com.cdv.CPS.shipping.repository.ClientTypeRepo;
import com.cdv.CPS.shipping.repository.CountryRepo;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class QuoteService {

    private static final BigDecimal VOLUME_FACTOR = new BigDecimal("1.66");

    private static final BigDecimal HALF = new BigDecimal("0.5");

    private static final BigDecimal PERCENT = new BigDecimal("100");

    private final CountryRepo countryRepo;
    private final ClientTypeRepo clientTypeRepo;

    public QuoteService(CountryRepo countryRepo, ClientTypeRepo clientTypeRepo) {
        this.countryRepo = countryRepo;
        this.clientTypeRepo = clientTypeRepo;
    }

    public QuoteResponse calculateQuote(QuoteRequest req) {

        validate(req);

        CountryEntity destination = countryRepo.findById(req.getDestinationCountryId())
                .orElseThrow(() -> new IllegalArgumentException("Destination country not found"));

        BigDecimal rate = destination.getRate();

        int discountPercent = 0;

        if (req.getClientTypeId() != null) {

            Client_TypeEntity ct = clientTypeRepo.findById(req.getClientTypeId())
                    .orElseThrow(() -> new IllegalArgumentException("Client type not found"));
            discountPercent = ct.getDiscount();
        }

        BigDecimal weight = req.getWeight();
        BigDecimal width = req.getWidth();
        BigDecimal height = req.getHeight();
        BigDecimal length = req.getLength();


        BigDecimal baseC = weight.multiply(rate);

        BigDecimal volumeC = VOLUME_FACTOR
                .multiply(height)
                .multiply(length)
                .multiply(width);

        BigDecimal discountFactor = new BigDecimal(discountPercent)
                .divide(PERCENT, 6, RoundingMode.HALF_UP);

        BigDecimal discountA = discountFactor
                .multiply(HALF)
                .multiply(weight);

        // (peso*tarifa) + (1.66*alto*largo*ancho) - (descuentoFactor*0.5*peso)
        BigDecimal total = baseC.add(volumeC).subtract(discountA);

        baseC = baseC.setScale(2, RoundingMode.HALF_UP);
        volumeC = volumeC.setScale(2, RoundingMode.HALF_UP);
        discountA = discountA.setScale(4, RoundingMode.HALF_UP);
        total = total.setScale(2, RoundingMode.HALF_UP);

        return new QuoteResponse(rate, discountPercent, baseC, volumeC, discountA, total);
    }

    private void validate(QuoteRequest req) {

        if (req.getDestinationCountryId() == null) {
            throw new IllegalArgumentException("destinationCountryId is required");
        }

        if (isNullOrNonPositive(req.getWeight())
                || isNullOrNonPositive(req.getWidth())
                || isNullOrNonPositive(req.getHeight())
                || isNullOrNonPositive(req.getLength())) {
            throw new IllegalArgumentException("weight/width/height/length must be > 0");
        }
    }

    private boolean isNullOrNonPositive(BigDecimal v) {
        return v == null || v.compareTo(BigDecimal.ZERO) <= 0;
    }
}