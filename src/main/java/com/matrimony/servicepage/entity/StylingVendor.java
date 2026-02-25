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

    @PrePersist
    protected void generateId() {
        if (this.stylingVendorId == null || this.stylingVendorId.isBlank()) {
            this.stylingVendorId = BeanUtil.getBean(IdGeneratorService.class)
                    .generateMonthlyId("StylingVendor",
                            "stylingVendorId",
                            "SVF",
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
    private String salonName;

    @Column(nullable = false)
    private String leadStylistName;

    @ElementCollection
    @CollectionTable(
            name = "styling_vendor_services",
            joinColumns = @JoinColumn(name = "vendor_id")
    )
    @Column(name = "type_of_styling_services_provided", nullable = false)
    private List<String> typeOfStylingServicesProvided = new ArrayList<>();

    private String other;

    @Column(nullable = false)
    private BigDecimal minBudgetRange;

    @Column(nullable = false)
    private BigDecimal maxBudgetRange;

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
    @ElementCollection
    @CollectionTable(
            name = "styling_vendor_bridal_makeup_styles",
            joinColumns = @JoinColumn(name = "vendor_id")
    )
    @Column(name = "bridal_makeup_styles", nullable = false)
    private List<String> bridalMakeupStyles = new ArrayList<>();

    @ElementCollection
    @CollectionTable(
            name = "styling_vendor_groom-styling_services",
            joinColumns = @JoinColumn(name = "vendor_id")
    )
    @Column(name = "groomStylingServices", nullable = false)
    private List<String> groomStylingServices = new ArrayList<>();

    // Step 5
    @ElementCollection
    @CollectionTable(
            name = "styling_vendor_products_used",
            joinColumns = @JoinColumn(name = "vendor_id")
    )
    @Column(name = "productsUsed", nullable = false)
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
    @ElementCollection
    @CollectionTable(
            name = "styling_vendor_preferred_locations",
            joinColumns = @JoinColumn(name = "vendor_id")
    )
    @Column(name = "preferred_locations", nullable = false)
    private List<String> preferredLocations = new ArrayList<>();

    @Column(nullable = false)
    private Boolean travelChargesApplicable;

    @Column(columnDefinition = "TEXT")
    private String specialDescription;

    @ElementCollection
    @CollectionTable(
            name = "styling_vendor_work_photos",
            joinColumns = @JoinColumn(name = "vendor_id")
    )
    @Column(name = "work_photos")
    private List<String> workPhotos = new ArrayList<>();

    @ElementCollection
    @CollectionTable(
            name = "styling_vendor_portfolio",
            joinColumns = @JoinColumn(name = "vendor_id")
    )
    @Column(name = "portfolio")
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


    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}