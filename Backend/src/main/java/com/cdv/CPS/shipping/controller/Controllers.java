package com.cdv.CPS.shipping.controller;

import com.cdv.CPS.shipping.dto.CountryDto;
import com.cdv.CPS.shipping.entity.Client_TypeEntity;
import com.cdv.CPS.shipping.entity.CountryEntity;
import com.cdv.CPS.shipping.entity.RegionEntity;
import com.cdv.CPS.shipping.service.Services;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Controllers {
    private final Services services;
    public Controllers(Services services){
        this.services = services;
    }
    @GetMapping("/regions")
    public List<RegionEntity> regions(){
        return services.getRegions();
    }
    @GetMapping("/countries")
    public List<CountryDto> countries(@RequestParam(required = false) Integer regionId){
        return services.getCountries(regionId);
    }
    @GetMapping("/client-types")
    public List<Client_TypeEntity> client_types(){
        return services.getClientTypes();
    }
}
