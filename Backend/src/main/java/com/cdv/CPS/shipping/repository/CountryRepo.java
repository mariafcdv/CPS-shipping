package com.cdv.CPS.shipping.repository;

import com.cdv.CPS.shipping.entity.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CountryRepo extends JpaRepository<CountryEntity, Integer> {
    List<CountryEntity> findByRegion_RegionId(Integer regionId);
}
