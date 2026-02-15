package com.cdv.CPS.shipping.dto;

import java.math.BigDecimal;

public class QuoteResponse {
    private BigDecimal rate;
    private Integer discountPercent;

    private BigDecimal baseCost;
    private BigDecimal volumeCost;
    private BigDecimal discountAmount;
    private BigDecimal total;

    public QuoteResponse(BigDecimal rate, Integer discountPercent, BigDecimal baseCost, BigDecimal volumeCost, BigDecimal discountAmount, BigDecimal total){
        this.rate = rate;
        this.discountPercent = discountPercent;
        this.baseCost = baseCost;
        this.volumeCost = volumeCost;
        this.discountAmount = discountAmount;
        this.total = total;
    }
    public BigDecimal getRate(){
        return rate;
    }
    public Integer getDiscountPercent(){
        return discountPercent;
    }

    public BigDecimal getBaseC() {
        return baseCost;
    }

    public BigDecimal getVolumeCost() {
        return volumeCost;
    }

    public BigDecimal getDiscountA() {
        return discountAmount;
    }

    public BigDecimal getTotal() {
        return total;
    }
}
