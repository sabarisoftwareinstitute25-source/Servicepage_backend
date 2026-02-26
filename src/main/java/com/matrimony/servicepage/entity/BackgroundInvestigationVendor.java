package com.matrimony.servicepage.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.matrimony.servicepage.util.BeanUtil;
import com.matrimony.servicepage.util.IdGeneratorService;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "background_investigation_vendors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BackgroundInvestigationVendor {

    @Id
    @Column(name = "background_investigation_id", length = 25)
    private String backgroundInvestigationVendorId;

    @PrePersist
    protected void prePersist() {

        // 1️⃣ Generate ID
        if (this.backgroundInvestigationVendorId == null
                || this.backgroundInvestigationVendorId.isBlank()) {

            this.backgroundInvestigationVendorId =
                    BeanUtil.getBean(IdGeneratorService.class)
                            .generateMonthlyId(
                                    "BackgroundInvestigationVendor",
                                    "backgroundInvestigationVendorId",
                                    "BVF",
                                    null,
                                    4);
        }

        // 2️⃣ Set Created Time
        if (this.createdAt == null) {
            this.createdAt = LocalDateTime.now();
        }
    }

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "vendor_id", nullable = false, unique = true)
    private Vendor vendor;

    // Step 1
    @Column(nullable = false)
    private String registeredAgencyName;


    @Column(name = "type_of_entity", nullable = false)
    private String typeOfEntity;

    @Column(nullable = false)
    private Integer yearOfEstablishment;

    private String registrationNumber;
    private String gstNumber;

    @Column(nullable = false)
    private String panNumber;

    @Column(nullable = false)
    private BigDecimal minBudgetRange;

    @Column(nullable = false)
    private BigDecimal maxBudgetRange;

    // Step 2
    @Column(nullable = false)
    private String privateDetectiveLicenseNumber;

    @Column(nullable = false)
    private String issuingAuthority;

    @Column(nullable = false)
    private String statesOfOperation;

    @Column(nullable = false)
    private LocalDate licenseValidityFrom;

    @Column(nullable = false)
    private LocalDate licenseValidityTo;

    // Step 3
    @Column(nullable = false)
    private String registeredOfficeAddress;

    private String branchOfficeAddress;

    @Column(nullable = false)
    private String district;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private Integer pinCode;

    // Step 4
    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private String designation;

    @Column(nullable = false)
    private Long mobileNumber;

    private Long alternateContactNumber;

    @Column(nullable = false)
    private String emailId;

    // Step 5
    @ElementCollection
    @CollectionTable(
            name = "background_investigation_matrimonial_verification_checks",
            joinColumns = @JoinColumn(name = "vendor_id")
    )
    @Column(name = "matrimonial_verification_checks", nullable = false)
    private List<String> matrimonialVerificationChecks = new ArrayList<>();

    @Column(nullable = false)
    private String regionsCovered;

    private Integer numberOfFieldInvestigators;

    @Column(nullable = false)
    private String averageTurnaroundTime;

    private String languagesSupported;

    // Step 6
    @Column(nullable = false)
    private Integer yearsOfExperienceInMatrimonialVerification;

    private String existingClients;

    private String referenceContact;

    // Step 7
    @ElementCollection
    @CollectionTable(
            name = "background_investigation_compliance_and_confidentiality",
            joinColumns = @JoinColumn(name = "vendor_id")
    )
    @Column(name = "compliance_and_confidentiality", nullable = false)
    private List<String> complianceAndConfidentiality = new ArrayList<>();

    // Step 8
    @ElementCollection
    @CollectionTable(
            name = "background_investigation_upload_documents",
            joinColumns = @JoinColumn(name = "vendor_id")
    )
    @Column(name = "upload_documents")
    private List<String> uploadDocuments = new ArrayList<>();

    // Step 9
    private String bankName;
    private String accountHolderName;
    private String accountNumber;
    private String ifscCode;

    // Step 10
    @Column(nullable = false)
    private String authorizedSignatoryName;

    @Column(nullable = false)
    private Boolean acceptedTerms;

    @Column(nullable = false)
    private String signaturePath;

    @Column(nullable = false)
    private LocalDate declarationDate;

    @Column(nullable = false)
    private String place;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;


    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}