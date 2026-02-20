package com.matrimony.servicepage.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
public class PhotographyVendorFilterRequest {

    private BigDecimal minBudgetRange;
    private BigDecimal maxBudgetRange;
    private String state;
    private String district;
    private List<String> preferredLocations;
    private Boolean travelChargesApplicable;
    private Integer yearsOfExperience;  //min year
    private String businessType;
    private Integer photoDeliveryDays;
    private Integer videoDeliveryDays;
    private Integer albumDeliveryDays;

}
