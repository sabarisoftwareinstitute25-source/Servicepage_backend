package com.matrimony.servicepage.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
public class EntertainmentVendorFilterRequest {

    private List<String> typeOfEntertainmentServices;
    private BigDecimal minBudgetRange;
    private BigDecimal MaxBudgetRange;
    private String state;
    private String district;
    private String businessType;
    private Integer yearsOfExperience;
    private List<String> eventsCovered;
    private Integer typicalPerformanceDuration;
    private Boolean customPerformancesAvailable;
    private Boolean soundSystemProvided;
    private Boolean lightingSetupProvided;
    private Boolean specialEffects;
    private Integer powerRequirement;
    private Boolean backupEquipmentAvailable;
    private Integer numberOfPerformers;
    private Boolean uniform;
    private Boolean setup;
    private List<String> preferredLocations;
    private Boolean accommodationChargesApplicable;
    private Boolean  timeRestrictionsAware;
    private Boolean advancePaymentRequired;
    private String overtimeCharges;

}

