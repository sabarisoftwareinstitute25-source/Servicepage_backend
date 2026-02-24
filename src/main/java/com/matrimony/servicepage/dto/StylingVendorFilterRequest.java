package com.matrimony.servicepage.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
public class StylingVendorFilterRequest {

    private BigDecimal minBudgetRange;
    private BigDecimal maxBudgetRange;
    private String state;
    private String district;
    private List<String> bridalMakeupStyles;
    private List<String> groomStylingServices;
    private List<String> productsUsed;
    private String businessType;
    private Integer yearsOfExperience;
    private Boolean ownMakeupKit;
    private Boolean backupArtistAvailable;
    private Boolean hygieneKitsUsed;
    private Boolean patchTestAvailable;
    private Boolean travelChargesApplicable;
    private Boolean advancePaymentRequired;
    private Boolean gst;
    private Boolean pan;

}
