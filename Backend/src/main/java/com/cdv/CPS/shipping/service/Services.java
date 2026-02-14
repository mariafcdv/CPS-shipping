package com.cdv.CPS.shipping.service;

import com.cdv.CPS.shipping.dto.CountryDto;
import com.cdv.CPS.shipping.entity.Client_TypeEntity;
import com.cdv.CPS.shipping.entity.CountryEntity;
import com.cdv.CPS.shipping.entity.RegionEntity;
import com.cdv.CPS.shipping.repository.ClientTypeRepo;
import com.cdv.CPS.shipping.repository.CountryRepo;
import com.cdv.CPS.shipping.repository.RegionRepo;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Services {
    private final RegionRepo regionRepo;
    private final CountryRepo countryRepo;
    private final ClientTypeRepo clientTypeRepo;

    public Services(RegionRepo regionRepo, CountryRepo countryRepo, ClientTypeRepo clientTypeRepo) {
        this.regionRepo = regionRepo;
        this.countryRepo = countryRepo;
        this.clientTypeRepo = clientTypeRepo;
    }
    public List<RegionEntity> getRegions(){
        return regionRepo.findAll();
    }
    public List<CountryDto> getCountries(Integer regionId) {
        List<CountryEntity> list = (regionId == null)
                ? countryRepo.findAll()
                : countryRepo.findByRegion_RegionId(regionId);

        return list.stream().map(this::toDto).toList();
    }
    private CountryDto toDto(CountryEntity c) {
        return new CountryDto(
                c.getCountryId(),
                c.getName(),
                c.getRate(),
                c.getRegion().getRegionId(),
                c.getRegion().getName()
        );
    }
    public List<Client_TypeEntity> getClientTypes(){
        return clientTypeRepo.findAll();
    }
}
