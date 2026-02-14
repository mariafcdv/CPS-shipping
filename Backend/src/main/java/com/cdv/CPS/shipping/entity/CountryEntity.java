package com.cdv.CPS.shipping.entity;

import jakarta.persistence.*;

import javax.swing.plaf.synth.Region;
import java.math.BigDecimal;

@Entity
@Table(name = "Country")

public class CountryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Country_ID")
    private Integer countryId;

    @Column(name = "Name", nullable = false, length = 50)
    private String name;

    @Column(name = "Rate", nullable = false, precision = 10, scale = 2)
    private BigDecimal rate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Region_ID", nullable = false)
    private RegionEntity region;

    public Integer getCountryId() {
        return countryId;
    }
    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public RegionEntity getRegion() {
        return region;
    }

    public void setRegion(RegionEntity region) {
        this.region = region;
    }
}
