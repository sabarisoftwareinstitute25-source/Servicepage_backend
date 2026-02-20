package com.matrimony.servicepage.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "catering_vendors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CateringVendor {

    @Id
    @Column(name = "catering_vendor_id", nullable = false, unique = true, length = 20)
    private String cateringVendorId;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "vendor_id", nullable = false, unique = true)
    private Vendor vendor;

    // Step 1
    @Column(nullable = false)
    private String companyName;

    @Column(nullable = false)
    private String contactPersonName;

    // FIXED
    @ElementCollection
    @CollectionTable(
            name = "catering_vendor_type_of_catering",
            joinColumns = @JoinColumn(name = "vendor_id")
    )
    @Column(name = "type_of_catering", nullable = false)
    private List<String> typeOfCatering = new ArrayList<>();

    private String otherCateringType;

    @Column(nullable = false)
    private BigDecimal minBudgetRange;

    @Column(nullable = false)
    private BigDecimal maxBudgetRange;

    // Step 2
    @Column(nullable = false)
    private Long mobileNumber;

    private Long alternateMobileNumber;

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

    // Step 3
    @Column(nullable = false)
    private String businessType;

    private String gstNumber;

    @Column(nullable = false)
    private String panNumber;

    private String FSSAILicenseNumber;

    @Column(nullable = false)
    private Integer yearOfExperience;

    // Step 4
    @ElementCollection
    @CollectionTable(
            name = "catering_vendor_cuisines_offered",
            joinColumns = @JoinColumn(name = "vendor_id")
    )
    @Column(name = "cuisines_offered", nullable = false)
    private List<String> cuisinesOffered = new ArrayList<>();

    private String otherCuisine;

    @ElementCollection
    @CollectionTable(
            name = "catering_vendor_special_menus_available",
            joinColumns = @JoinColumn(name = "vendor_id")
    )
    @Column(name = "special_menus_available", nullable = false)
    private List<String> specialMenusAvailable = new ArrayList<>();

    // Step 5
    @Column(nullable = false)
    private BigDecimal minPlateCapacity;

    @Column(nullable = false)
    private BigDecimal maxPlateCapacity;

    @Column(nullable = false)
    private String serviceType;

    @Column(nullable = false)
    private Boolean servingStaffProvided;

    @Column(nullable = false)
    private Boolean uniformedStaff;

    // Step 6
    @Column(nullable = false)
    private Integer pricePerPlateFrom;

    @Column(nullable = false)
    private Integer pricePerPlateTo;

    @Column(nullable = false)
    private Boolean advancePaymentRequired;

    private String balancePaymentTerms;

    // Step 7
    @Column(nullable = false)
    private Boolean FSSAICompliance;

    @Column(nullable = false)
    private String foodPreparationLocation;

    @Column(nullable = false)
    private Boolean waterSource;

    @Column(nullable = false)
    private Boolean wasteManagementArranged;

    // Step 8
    @ElementCollection
    @CollectionTable(
            name = "catering_vendor_preferred_locations",
            joinColumns = @JoinColumn(name = "vendor_id")
    )
    @Column(name = "preferred_locations", nullable = false)
    private List<String> preferredLocations = new ArrayList<>();

    @Column(nullable = false)
    private Boolean transportationChargesApplicable;

    @Column(columnDefinition = "TEXT")
    private String description;


    @ElementCollection
    @CollectionTable(
            name = "catering_vendor_work_photos",
            joinColumns = @JoinColumn(name = "vendor_id")
    )
    @Column(name = "work_photos")
    private List<String> workPhotos = new ArrayList<>();

    @ElementCollection
    @CollectionTable(
            name = "catering_vendor_portfolio",
            joinColumns = @JoinColumn(name = "vendor_id")
    )
    @Column(name = "portfolio")
    private List<String> portfolio = new ArrayList<>();

    // Step 9
    @Column(nullable = false)
    private Long numberOfWeddingsCatered;

    private String majorClients;

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

    @Column(nullable = false)
    private Boolean acceptedTerms;

    @Column(nullable = false)
    private String signaturePath;

    @Column(nullable = false)
    private LocalDate declarationDate;

    @Column(nullable = false)
    private String place;

    // Timestamps
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