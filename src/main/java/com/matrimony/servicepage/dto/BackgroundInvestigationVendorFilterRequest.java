    package com.matrimony.servicepage.dto;


    import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
    import lombok.Data;

    import java.math.BigDecimal;
    import java.time.LocalDate;
    import java.util.List;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @Data
    public class BackgroundInvestigationVendorFilterRequest {

        private String typeOfEntity;
        private Integer yearOfEstablishment;
        private BigDecimal minBudgetRange;
        private BigDecimal maxBudgetRange;
        private Boolean licenseVerified;
       // private String statesOfOperation;
        private String state;
        private String district;
        private List<String> matrimonialVerificationChecks;
        private String regionsCovered;
        private Integer numberOfFieldInvestigators;
       // private String averageTurnaroundTime;
        private String yearsOfExperienceInMatrimonialVerification;

    }
