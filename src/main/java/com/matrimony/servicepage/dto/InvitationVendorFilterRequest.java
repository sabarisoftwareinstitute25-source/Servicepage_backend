package com.matrimony.servicepage.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
public class InvitationVendorFilterRequest {

    private List<String> typeOfServicesProvided;
    private BigDecimal minBudgetRange;
    private BigDecimal maxBudgetRange;
    private String businessType;
    private Integer yearsOfExperience;
    private List<String> invitationTypesOffered;
    private List<String> printingOptions;
    private Boolean customizationAvailable;
    private List<String> typesOfGiftsOffered;
    private Boolean namePrintingAvailable;
    private Boolean wrappingIncluded;
    private BigDecimal invitationMinPrice;
    private BigDecimal invitationMaxPrice;
    private BigDecimal giftMinPrice;
    private BigDecimal giftMaxPrice;
    private Boolean advancePaymentRequired;
    private Integer designApproval;
    private Integer printing;
    private Integer giftPreparation;
    private String state;
    private String district;
    private List<String> serviceCoverageLocations;
    private Boolean travelChargesApplicable;

}
