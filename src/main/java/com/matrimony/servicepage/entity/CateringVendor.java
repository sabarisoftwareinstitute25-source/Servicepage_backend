package com.matrimony.servicepage.entity;

import jakarta.persistence.*;
import lombok.*;
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
public class CateringVendor{

    @Id
    @Column(name = "catering_vendor_id", nullable = false, unique = true, length = 30)
    private String cateringVendorId;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "vendor_id", referencedColumnName = "vendor_id", nullable = false, unique = true)
    private Vendor vendor;

    // Step 1 - Basic
    @Column(nullable = false)
    private String companyName;

    @Column(nullable = false)
    private String contactPerson;

    @Column(name = "type_of_catering", columnDefinition = "TEXT",nullable = false)
    private List<String> typeOfCatering = new ArrayList<>();

    private String otherCateringType;

    // Step 2 - Contact
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

    // Step 3 - Business
    @Column(name = "business_type", columnDefinition = "TEXT",nullable = false)
    private String businessType;

    private String gstNumber;

    @Column(nullable = false)
    private String panNumber;

    private String fssaiLicenseNumber;

    @Column(nullable = false)
    private Integer yearOfExperience;

    // Step 4 - Cuisine
    @Column(name = "cuisines_offered", columnDefinition = "TEXT",nullable = false)
    private List<String> cuisinesOffered = new ArrayList<>();

    private String otherCuisine;

    @Column(name = "special_menus_available", columnDefinition = "TEXT",nullable = false)
    private List<String> specialMenusAvailable = new ArrayList<>();

    // Step 5 - Capacity
    @Column(nullable = false)
    private Integer minPlateCapacity;

    @Column(nullable = false)
    private Integer maxPlateCapacity;

    @Column(name = "service_type", columnDefinition = "TEXT",nullable = false)
    private String serviceType;

    @Column(nullable = false)
    private Boolean servingStaffProvided;

    @Column(nullable = false)
    private Boolean uniformedStaff;

    // Step 6 - Pricing
    @Column(nullable = false)
    private Integer pricePerPlateFrom;

    @Column(nullable = false)
    private Integer pricePerPlateTo;

    @Column(nullable = false)
    private Boolean advancePaymentRequired;

    private String balancePaymentTerms;

    // Step 7 - Hygiene
    @Column(nullable = false)
    private Boolean fssaiCompliance;

    @Column(nullable = false)
    private String foodPreparationLocation;

    @Column(nullable = false)
    private Boolean waterSource;

    @Column(nullable = false)
    private Boolean wasteManagementArranged;

    // Step 8 - Coverage
    @Column(name = "preferred_locations", columnDefinition = "TEXT",nullable = false)
    private List<String> preferredLocations = new ArrayList<>();

    @Column(nullable = false)
    private Boolean transportationChargesApplicable;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "work_Photo", columnDefinition = "TEXT")
    private List<String> workPhoto = new ArrayList<>();

    @Column(name = "portfolio", columnDefinition = "TEXT")
    private List<String> portfolio = new ArrayList<>();

    // Step 9 - Experience
    @Column(nullable = false)
    private Long numberOfWeddingsCatered;

    private String references;

    // Step 10 - Bank
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