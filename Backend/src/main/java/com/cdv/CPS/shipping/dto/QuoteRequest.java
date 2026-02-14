package com.cdv.CPS.shipping.dto;

import java.math.BigDecimal;

public class QuoteRequest {
    private BigDecimal weight;
    private BigDecimal width;
    private BigDecimal height;
    private BigDecimal length;

    private Integer originCountryId;
    private Integer destinationCountryId;
    private Integer clientTypeId;

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public BigDecimal getWidth() {
        return width;
    }

    public void setWidth(BigDecimal width) {
        this.width = width;
    }

    public BigDecimal getHeight() {
        return height;
    }

    public void setHeight(BigDecimal height) {
        this.height = height;
    }

    public BigDecimal getLength() {
        return length;
    }

    public void setLength(BigDecimal length) {
        this.length = length;
    }

    public Integer getOriginCountryId() {
        return originCountryId;
    }

    public void setOriginCountryId(Integer originCountryId) {
        this.originCountryId = originCountryId;
    }

    public Integer getDestinationCountryId() {
        return destinationCountryId;
    }

    public void setDestinationCountryId(Integer destinationCountryId) {
        this.destinationCountryId = destinationCountryId;
    }

    public Integer getClientTypeId() {
        return clientTypeId;
    }

    public void setClientTypeId(Integer clientTypeId) {
        this.clientTypeId = clientTypeId;
    }
}
