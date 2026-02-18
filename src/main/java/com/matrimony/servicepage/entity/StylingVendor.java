package com.matrimony.servicepage.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "styling_vendors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StylingVendor {

    @Id
    @Column(name = "styling_vendor_id", nullable = false, length = 30)
    private String stylingVendorId;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "vendor_id", nullable = false, unique = true)
    private Vendor vendor;

    // Step 1
    @Column(nullable = false)
    private String salonName;

    @Column(nullable = false)
    private String leadStylistName;

    @Column(name = "type_of_styling_services_provided", columnDefinition = "TEXT",nullable = false)
    private List<String> typeOfStylingServicesProvided = new ArrayList<>();

    private String other;

    // Step 2
    @Column(nullable = false)
    private String mobileNumber;

    private String alternateMobileNumber;

    @Column(nullable = false)
    private String emailId;

    @Column(nullable = false)
    private String studioAddress;

    @Column(nullable = false)
    private String district;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private Integer pinCode;

    // Step 3
    @Column(name = "business_type", columnDefinition = "TEXT",nullable = false)
    private String businessType;

    private String gstNumber;

    @Column(nullable = false)
    private String panNumber;

    private String professionalCertification;

    @Column(nullable = false)
    private Integer yearsOfExperience;

    // Step 4
    @Column(name = "bridal_makeup_styles", columnDefinition = "TEXT",nullable = false)
    private List<String> bridalMakeupStyles = new ArrayList<>();

    @Column(name = "groom_styling_services", columnDefinition = "TEXT",nullable = false)
    private List<String> groomStylingServices = new ArrayList<>();

    // Step 5
    @Column(name = "products_used", columnDefinition = "TEXT",nullable = false)
    private List<String> productsUsed = new ArrayList<>();

    private String otherPremiumBrands;

    @Column(nullable = false)
    private Boolean hygieneKitsUsed;

    @Column(nullable = false)
    private Boolean patchTestAvailable;

    // Step 6
    @Column(nullable = false)
    private Integer numberOfStylists;

    @Column(nullable = false)
    private Boolean ownMakeupKit;

    @Column(nullable = false)
    private Boolean backupArtistAvailable;

    // Step 7
    @Column(name = "preferred_locations", columnDefinition = "TEXT",nullable = false)
    private List<String> preferredLocations = new ArrayList<>();

    @Column(nullable = false)
    private Boolean travelChargesApplicable;

    @Column(columnDefinition = "TEXT")
    private String specialDescription;

    @Column(name = "work_photos", columnDefinition = "TEXT")
    private List<String> workPhotos = new ArrayList<>();

    @Column(name = "portfolio", columnDefinition = "TEXT",nullable = false)
    private List<String> portfolio = new ArrayList<>();

    // Step 8
    @Column(nullable = false)
    private Integer bridalPackage;

    @Column(nullable = false)
    private Integer groomPackage;

    private Integer engagementPackage;

    private Integer mehendiCharges;

    @Column(nullable = false)
    private Boolean advancePaymentRequired;

    // Step 9
    @Column(nullable = false)
    private Integer numberOfWeddingsStyled;

    private String websiteLink;

    // Step 10
    @Column(nullable = false)
    private String accountHolderName;

    @Column(nullable = false)
    private String bankName;

    @Column(nullable = false)
    private String accountNumber;

    @Column(nullable = false)
    private String ifscCode;

    private String upiId;

    // Step 11
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
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}