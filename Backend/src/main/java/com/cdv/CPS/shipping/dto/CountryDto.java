package com.cdv.CPS.shipping.dto;

import java.math.BigDecimal;

public class CountryDto {
    private Integer countryId;
    private String name;
    private BigDecimal rate;
    private Integer regionId;
    private String regionName;

    public CountryDto(Integer countryId, String name, BigDecimal rate, Integer regionId, String regionName) {
        this.countryId = countryId;
        this.name = name;
        this.rate = rate;
        this.regionId = regionId;
        this.regionName = regionName;
    }

    public Integer getCountryId() { return countryId; }
    public String getName() { return name; }
    public BigDecimal getRate() { return rate; }
    public Integer getRegionId() { return regionId; }
    public String getRegionName() { return regionName; }
}
