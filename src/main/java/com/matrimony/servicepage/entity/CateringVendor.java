package com.matrimony.servicepage.entity;

import com.matrimony.servicepage.enums.*;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.math.BigDecimal;

@Entity
@Table(name = "catering_vendors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CateringVendor {

    @Id
    @Column(name = "catering_vendor_id", nullable = false, unique = true, length = 30)
    private String cateringVendorId;

    // Vendor mapping (generated from Vendor class)
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "vendor_id", referencedColumnName = "vendor_id", nullable = false, unique = true)
    private Vendor vendor;

    // =============================
    // Step 1 - Basic
    // =============================
    @Column(nullable = false)
    private String companyName;

    @Column(nullable = false)
    private String contactPerson;

    @ElementCollection
    @CollectionTable(name = "caterer_types",
            joinColumns = @JoinColumn(name = "catering_vendor_id"))
    @Column(name = "type_of_catering", nullable = false)
    private List<String> typeOfCatering = new ArrayList<>();

    private String otherCateringType;

    // =============================
    // Step 2 - Contact
    // =============================
    @Column(nullable = false)
    private String mobileNumber;

    private String alternateMobileNumber;

    @Column(nullable = false)
    private String emailId;

    @Column(nullable = false, length = 500)
    private String address;

    @Column(nullable = false)
    private String district;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private Integer pinCode;

    // =============================
    // Step 3 - Business
    // =============================
    @Enumerated(EnumType.STRING)
    private BusinessType businessType;

    private String gstNumber;

    @Column(nullable = false)
    private String panNumber;

    private String fssaiLicenseNumber;

    @Column(nullable = false)
    private Integer yearOfExperience;

    // =============================
    // Step 4 - Cuisine
    // =============================

    @ElementCollection
    @CollectionTable(name = "catering_cuisines",
            joinColumns = @JoinColumn(name = "catering_vendor_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "cuisine_type")
    private List<CuisinesOfOffered> cuisinesOffered = new ArrayList<>();

    private String otherCuisine;

    @ElementCollection
    @CollectionTable(name = "catering_special_menus",
            joinColumns = @JoinColumn(name = "catering_vendor_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "special_menu")
    private List<SpecialMenusAvailable> specialMenusAvailable = new ArrayList<>();

    // =============================
    // Step 5 - Capacity
    // =============================
    @Column(nullable = false)
    private Integer minPlateCapacity;

    @Column(nullable = false)
    private Integer maxPlateCapacity;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ServiceType serviceType;

    @Column(nullable = false)
    private Boolean servingStaffProvided;

    @Column(nullable = false)
    private Boolean uniformedStaff;

    // =============================
    // Step 6 - Pricing
    // =============================
    @Column(nullable = false)
    private Integer pricePerPlateFrom;

    @Column(nullable = false)
    private Integer pricePerPlateTo;

    @Column(nullable = false)
    private Boolean advancePaymentRequired;

    private String balancePaymentTerms;

    // =============================
    // Step 7 - Hygiene
    // =============================
    @Column(nullable = false)
    private Boolean fssaiCompliance;

    @Column(nullable = false)
    private String foodPreparationLocation;

    @Column(nullable = false)
    private Boolean waterSource;

    @Column(nullable = false)
    private Boolean wasteManagementArranged;

    // =============================
    // Step 8 - Coverage
    // =============================

    @ElementCollection
    @CollectionTable(name = "catering_preferred_locations",
            joinColumns = @JoinColumn(name = "catering_vendor_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "preferred_location")
    private Set<PreferredLocation> preferredLocations = new HashSet<>();

    @Column(nullable = false)
    private Boolean transportationChargesApplicable;

    @Column(columnDefinition = "TEXT")
    private String description;

    @ElementCollection
    @CollectionTable(name = "catering_work_photos",
            joinColumns = @JoinColumn(name = "catering_vendor_id"))
    @Column(name = "photo_path")
    private List<String> workPhotoPaths = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "catering_portfolio_links",
            joinColumns = @JoinColumn(name = "catering_vendor_id"))
    @Column(name = "link")
    private List<String> portfolioLinks = new ArrayList<>();

    // =============================
    // Step 9 - Experience
    // =============================
    @Column(nullable = false)
    private Long numberOfWeddingsCatered;

    private String references;

    // =============================
    // Step 10 - Bank
    // =============================
    @Column(nullable = false)
    private String accountHolderName;

    @Column(nullable = false)
    private String bankName;

    @Column(nullable = false)
    private String accountNumber;

    @Column(nullable = false)
    private String ifscCode;

    private String upiId;

    @Column(nullable = false)
    private Boolean acceptedTerms;

    @Column(nullable = false)
    private String signaturePath;

    @Column(nullable = false)
    private LocalDate declarationDate;

    @Column(nullable = false)
    private String place;

    // =============================
    // Timestamps
    // =============================
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    public void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}