package com.matrimony.servicepage.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
public class BackgroundInvestigationVendorFilterRequest {

    private BigDecimal minBudgetRange;
    private BigDecimal maxBudgetRange;
    private Integer yearOfEstablishment;
   // private Boolean LicenseVerified;
    private List<String> statesOfOperation;
    private LocalDate licenseValidityFrom;
    private LocalDate licenseValidityTo;
    private String state;
    private String district;
   // private String area;
    private Integer pinCode;
   // private String MainServiceType;
   // private List<String> AdditionalVerificationServices;
    private String regionsCovered;
    private String languagesSupported;
    private Integer numberOfFieldInvestigators;
    private String averageTurnaroundTime;
   // private String ReportFormat;
   // private Boolean TravelChargesApplicable;
    private String yearsOfExperienceInMatrimonialVerification;
    private String existingClients;
    private String ReferenceAvailable;
   // private List<String> ComplianceDeclarations;

}
