package com.matrimony.servicepage.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "decoration_vendors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DecorationVendor {

    @Id
    @Column(name = "decoration_vendor_id", nullable = false, length = 30)
    private String decorationVendorId;

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
            name = "decoration_vendor_type_of_services",
            joinColumns = @JoinColumn(name = "vendor_id")
    )
    @Column(name = "type_of_decoration_services", nullable = false)
    private List<String> typeOfDecorationServices = new ArrayList<>();

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
            name = "decoration_vendor_styles_offered",
            joinColumns = @JoinColumn(name = "vendor_id")
    )
    @Column(name = "decoration_styles_offered", nullable = false)
    private List<String> decorationStylesOffered = new ArrayList<>();

    @ElementCollection
    @CollectionTable(
            name = "decoration_vendor_materials-used",
            joinColumns = @JoinColumn(name = "vendor_id")
    )
    @Column(name = "materials_used", nullable = false)
    private List<String> materialsUsed = new ArrayList<>();

    // Step 5
    @ElementCollection
    @CollectionTable(
            name = "decoration_vendor_services_includes",
            joinColumns = @JoinColumn(name = "vendor_id")
    )
    @Column(name = "services_included", nullable = false)
    private List<String> servicesIncluded = new ArrayList<>();

    private Integer setupTimeRequired;

    @Column(nullable = false)
    private Boolean dismantlingIncluded;

    // Step 6
    private String basicDecorationPackage;
    private String premiumDecorationPackage;
    private String customDecoration;

    @Column(nullable = false)
    private Boolean advancePaymentRequired;

    // Step 7
    @ElementCollection
    @CollectionTable(
            name = "decoration_vendor_preferred_location",
            joinColumns = @JoinColumn(name = "vendor_id")
    )
    @Column(name = "preferred_locations", nullable = false)
    private List<String> preferredLocations = new ArrayList<>();

    @Column(nullable = false)
    private Boolean transportationChargesApplicable;

    @Column(columnDefinition = "TEXT")
    private String specialDescription;

    @ElementCollection
    @CollectionTable(
            name = "decoration_vendor_decoration_Photos",
            joinColumns = @JoinColumn(name = "vendor_id")
    )
    @Column(name = "decoration_photos")
    private List<String> decorationPhotos = new ArrayList<>();

    @ElementCollection
    @CollectionTable(
            name = "decoration_vendor_portfolio",
            joinColumns = @JoinColumn(name = "vendor_id")
    )
    @Column(name = "portfolio")
    private List<String> portfolio = new ArrayList<>();

    // Step 8
    private Integer numberOfStaffProvided;

    @Column(nullable = false)
    private Boolean uniformedStaff;

    @Column(nullable = false)
    private Boolean ownToolsEquipment;

    // Step 9
    @Column(name = "website_url", length = 500)
    private String websiteUrl;

    @Column(name = "google_maps_link", length = 500)
    private String googleMapsLink;

    @Column(name = "sample_work_link", length = 500)
    private String sampleWorkLink;

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