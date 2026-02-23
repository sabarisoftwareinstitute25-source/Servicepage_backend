package com.matrimony.servicepage.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
public class DecorationVendorFilterRequest {

    private BigDecimal minBudgetRange;
    private BigDecimal maxBudgetRange;
    private String state;
    private String district;
    private List<String> typeOfDecorationServices;
    private Integer yearsOfExperience;
    private String businessType;
    private List<String> decorationStylesOffered;
    private List<String> materialsUsed;
    private List<String> servicesIncluded;
    private List<String> preferredLocations;
    private Boolean transportationChargesApplicable;
}
