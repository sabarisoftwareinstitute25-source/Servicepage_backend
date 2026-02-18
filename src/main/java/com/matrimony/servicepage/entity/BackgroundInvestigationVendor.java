package com.matrimony.servicepage.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

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
    @Column(name = "background_investigation_vendor_id", nullable = false, length = 30)
    private String backgroundInvestigationVendorId;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "vendor_id", nullable = false, unique = true)
    private Vendor vendor;

    // Step 1
    @Column(nullable = false)
    private String registeredAgencyName;

    @Column(name = "type_of_entity", columnDefinition = "TEXT",nullable = false)
    private List<String> typeofEntity = new ArrayList<>();

    @Column(nullable = false)
    private Integer yearOfEstablishment;

    private String registrationNumber;
    private String gstNumber;

    @Column(nullable = false)
    private String panNumber;

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
    private String city;

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
    @Column(name = "matrimonial_verification_checks", columnDefinition = "TEXT",nullable = false)
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
    @Column(name = "compliance_and_confidentiality", columnDefinition = "TEXT",nullable = false)
    private List<String> complianceAndConfidentiality = new ArrayList<>();

    // Step 8
    @Column(name = "upload_documents", columnDefinition = "TEXT",nullable = false)
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

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}