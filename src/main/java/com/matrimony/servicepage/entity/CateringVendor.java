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
    private String contactPerson;

    // FIXED
    @Column(name = "type_of_catering",columnDefinition = "TEXT",nullable = false)
    private List<String> typeOfCatering = new ArrayList<>();

    private String otherCateringType;

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

    private String fssaiLicenseNumber;

    @Column(nullable = false)
    private Integer yearOfExperience;

    // Step 4
    @Column(name = "cuisines_offered",columnDefinition = "TEXT", nullable = false)
    private List<String> cuisinesOffered = new ArrayList<>();

    private String otherCuisine;

    @Column(name = "special_menus_available",columnDefinition = "TEXT", nullable = false)
    private List<String> specialMenusAvailable = new ArrayList<>();

    // Step 5
    @Column(nullable = false)
    private Integer minPlateCapacity;

    @Column(nullable = false)
    private Integer maxPlateCapacity;

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
    private Boolean fssaiCompliance;

    @Column(nullable = false)
    private String foodPreparationLocation;

    @Column(nullable = false)
    private Boolean waterSource;

    @Column(nullable = false)
    private Boolean wasteManagementArranged;

    // Step 8
    @Column(name = "preferred_locations",columnDefinition = "TEXT", nullable = false)
    private List<String> preferredLocations = new ArrayList<>();

    @Column(nullable = false)
    private Boolean transportationChargesApplicable;

    @Column(columnDefinition = "TEXT")
    private String description;


    @Column(name = "photo_path",columnDefinition = "TEXT")
    private List<String> workPhoto = new ArrayList<>();

    @Column(name = "portfolio_path",columnDefinition = "TEXT")
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