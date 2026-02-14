package com.cdv.CPS.shipping.entity;

import jakarta.persistence.*;
import org.yaml.snakeyaml.events.Event;

@Entity
@Table(name = "Region")

public class RegionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Region_ID")
    private Integer regionId;

    @Column(name = "Name", nullable = false, length = 50)
    private String name;

    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
