package com.matrimony.servicepage.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
public class CateringVendorFilterRequest {

    private BigDecimal minBudgetRange;
    private BigDecimal maxBudgetRange;
    private List<String> cuisinesOffered;
    private String state;
    private String district;
    private List<String> preferredLocations;
    private Boolean transportationChargesApplicable;
    private List<String> specialMenusAvailable;
    private List<String> serviceType;
    private BigDecimal minPlateCapacity;
    private BigDecimal mixPlateCapacity;
    private Boolean servingStaffProvided;
    private Boolean uniformedStaff;
    private Boolean FSSAICompliance;
    private String foodPreparationLocation;
    private Boolean waterSource;
    private Boolean wasteManagementArranged;
    private String businessType;
    private Integer yearsOfExperience;
    private Boolean advancePaymentRequired ;
    private List<String> documentsAvailable;

}
