package com.matrimony.servicepage.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.matrimony.servicepage.enums.*;
import jakarta.persistence.*;
import lombok.*;

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
    @CollectionTable(name = "decoration_type",
            joinColumns = @JoinColumn(name = "decoration_vendor_id"))
    @Column(name = "type_of_decoration_services")
    private List<String> typeOfDecorationServices = new ArrayList<>();

    private String other;

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
    @Enumerated(EnumType.STRING)
    private BusinessType businessType;

    private String gstNumber;

    @Column(nullable = false)
    private String panNumber;

    @Column(nullable = false)
    private Integer yearsOfExperience;

    // Step 4
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "decoration_style",
            joinColumns = @JoinColumn(name = "decoration_vendor_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "decoration_styles_offered")
    private List<DecorationStylesOffered> decorationStylesOffered = new ArrayList<>();

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "decoration_material_used",
            joinColumns = @JoinColumn(name = "decoration_vendor_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "materials_used")
    private List<MaterialsUsed> materialsUsed = new ArrayList<>();

    // Step 5
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "decoration_services_included",
            joinColumns = @JoinColumn(name = "decoration_vendor_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "services_included")
    private List<ServicesIncluded> servicesIncluded = new ArrayList<>();

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
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "decoration_preferred_locations",
            joinColumns = @JoinColumn(name = "decoration_vendor_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "location")
    private List<PreferredLocation> preferredLocations = new ArrayList<>();

    @Column(nullable = false)
    private Boolean transportationChargesApplicable;

    @Column(columnDefinition = "TEXT")
    private String specialDescription;

    @ElementCollection
    @CollectionTable(name = "decoration_photos",
            joinColumns = @JoinColumn(name = "decoration_vendor_id"))
    @Column(name = "photo_url")
    private List<String> decorationPhotos = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "decoration_portfolio",
            joinColumns = @JoinColumn(name = "decoration_vendor_id"))
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

    @ElementCollection
    @CollectionTable(name = "decoration_social_links",
            joinColumns = @JoinColumn(name = "decoration_vendor_id"))
    @Column(name = "social_link")
    private List<String> socialMediaLinks = new ArrayList<>();

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