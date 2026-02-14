package com.cdv.CPS.shipping.dto;

import java.math.BigDecimal;

public class QuoteResponse {
    private BigDecimal rate;
    private Integer discountPercent;

    private BigDecimal baseC;
    private BigDecimal volumeC;
    private BigDecimal discountA;
    private BigDecimal total;

    public QuoteResponse(BigDecimal rate, Integer discountPercent, BigDecimal baseC, BigDecimal volumeC, BigDecimal discountA, BigDecimal total){
        this.rate = rate;
        this.discountPercent = discountPercent;
        this.baseC = baseC;
        this.volumeC = volumeC;
        this.discountA = discountA;
        this.total = total;
    }
    public BigDecimal getRate(){
        return rate;
    }
    public Integer getDiscountPercent(){
        return discountPercent;
    }

    public BigDecimal getBaseC() {
        return baseC;
    }

    public BigDecimal getVolumeC() {
        return volumeC;
    }

    public BigDecimal getDiscountA() {
        return discountA;
    }

    public BigDecimal getTotal() {
        return total;
    }
}
