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
@Table(name = "entertainment_vendors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EntertainmentVendor {

    @Id
    @Column(name = "entertainment_vendor_id", nullable = false, length = 30)
    private String entertainmentVendorId;

    @PrePersist
    protected void generateId() {
        if (this.entertainmentVendorId == null || this.entertainmentVendorId.isBlank()) {
            this.entertainmentVendorId = BeanUtil.getBean(IdGeneratorService.class)
                    .generateMonthlyId("EntertainmentVendor",
                            "entertainmentVendorId",
                            "EVF",
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
    private String vendorName;

    @Column(nullable = false)
    private String contactPersonName;

    @ElementCollection
    @CollectionTable(
            name = "entertainment_vendor_service",
            joinColumns = @JoinColumn(name = "vendor_id")
    )
    @Column(name = "type_of_entertainment_services", nullable = false)
    private List<String> typeOfEntertainmentServices = new ArrayList<>();

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
    private String officeAddress;

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

    @Column(nullable = false)
    private Integer yearsOfExperience;

    // Step 4
    @ElementCollection
    @CollectionTable(
            name = "entertainment_vendor_events_covered",
            joinColumns = @JoinColumn(name = "vendor_id")
    )
    @Column(name = "events_covered", nullable = false)
    private List<String> eventsCovered = new ArrayList<>();

    @Column(nullable = false)
    private Integer typicalPerformanceDuration;

    @Column(nullable = false)
    private Boolean customPerformancesAvailable;

    // Step 5
    @Column(nullable = false)
    private Boolean soundSystemProvided;

    @Column(nullable = false)
    private Boolean lightingSetupProvided;

    @Column(nullable = false)
    private Boolean specialEffects;

    private Integer powerRequirement;

    @Column(nullable = false)
    private Boolean backupEquipmentAvailable;

    // Step 6
    @Column(nullable = false)
    private Integer numberOfPerformers;

    @Column(nullable = false)
    private Boolean uniform;

    @Column(nullable = false)
    private Boolean setup;

    // Step 7
    @ElementCollection
    @CollectionTable(
            name = "entertainment_vendor_preferred_locations",
            joinColumns = @JoinColumn(name = "vendor_id")
    )
    @Column(name = "preferred_locations")
    private List<String> preferredLocations = new ArrayList<>();

    @Column(nullable = false)
    private Boolean accommodationChargesApplicable;

    @Column(nullable = false)
    private Boolean timeRestrictionsAware;

    @Column(columnDefinition = "TEXT")
    private String specialDescription;

    @ElementCollection
    @CollectionTable(
            name = "entertainment_vendor_performance_photos",
            joinColumns = @JoinColumn(name = "vendor_id")
    )
    @Column(name = "performance_photos")
    private List<String> performancePhotos = new ArrayList<>();

    @ElementCollection
    @CollectionTable(
            name = "entertainment_vendor_portfolio",
            joinColumns = @JoinColumn(name = "vendor_id")
    )
    @Column(name = "portfolio")
    private List<String> portfolio = new ArrayList<>();

    // Step 8
    @Column(nullable = false)
    private String basicPackage;

    @Column(nullable = false)
    private String premiumPackage;

    @Column(nullable = false)
    private String customEventCharges;

    @Column(nullable = false)
    private Boolean advancePaymentRequired;

    private String overtimeCharges;

    // Step 9
    @Column(name = "website_url", length = 500)
    private String websiteUrl;

    @Column(name = "instagram_link", length = 500)
    private String instagramLink;

    @Column(name = "performance_video_link", length = 500)
    private String performanceVideoLink;

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