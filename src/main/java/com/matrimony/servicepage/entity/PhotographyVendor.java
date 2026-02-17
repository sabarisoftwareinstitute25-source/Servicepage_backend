package com.matrimony.servicepage.entity;

import com.matrimony.servicepage.enums.BusinessType;
import com.matrimony.servicepage.enums.PreferredLocation;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "photography_vendors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PhotographyVendor {

    @Id
    @Column(name = "photography_vendor_id", nullable = false, unique = true, length = 30)
    private String photographyVendorId;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "vendor_id", referencedColumnName = "vendor_id", nullable = false, unique = true)
    private Vendor vendor;

    // Step 1
    @Column(nullable = false)
    private String studioName;

    @Column(nullable = false)
    private String ownerName;

    @ElementCollection
    @CollectionTable(name = "photographer_services",
            joinColumns = @JoinColumn(name = "photography_vendor_id"))
    @Column(name = "service_name", nullable = false)
    private List<String> typeOfServices;

    private String otherService;

    // Step 2
    @Column(nullable = false)
    private String mobileNumber;

    private String alterMobileNumber;

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
    @Enumerated(EnumType.STRING)
    private BusinessType businessType;

    private String gstNumber;

    @Column(nullable = false)
    private String panNumber;

    @Column(nullable = false)
    private Integer yearsOfExperience;

    private String documentPath;

    // Step 4
    @Column(nullable = false)
    private String cameraModels;

    private String videoEquipment;

    @Column(nullable = false)
    private Integer noOfTeamMembers;

    private Boolean backupEquipmentAvailable;

    // Step 5
    @ElementCollection
    @CollectionTable(name = "photography_coverage_locations",
            joinColumns = @JoinColumn(name = "photography_vendor_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "location")
    private List<PreferredLocation> preferredLocations;

    private Boolean travelChargesApplicable;

    @Column(length = 2000)
    private String specialDescription;

    @ElementCollection
    @CollectionTable(name = "photography_work_photos",
            joinColumns = @JoinColumn(name = "photography_vendor_id"))
    @Column(name = "photo_path")
    private List<String> workPhotoPaths;

    @ElementCollection
    @CollectionTable(name = "photography_portfolio_links",
            joinColumns = @JoinColumn(name = "photography_vendor_id"))
    @Column(name = "link")
    private List<String> portfolioLinks;

    // Step 6
    @Column(nullable = false)
    private BigDecimal basicWeddingPackage;

    @Column(nullable = false)
    private BigDecimal fullWeddingPackage;

    private BigDecimal candidPhotography;
    private BigDecimal videographyCinematic;
    private BigDecimal albumCharges;

    // Step 7
    @Column(nullable = false)
    private Integer photoDeliveryDays;

    private Integer videoDeliveryDays;
    private Integer albumDeliveryDays;

    // Step 8
    private String websiteUrl;
    private String socialMediaHandle;
    private String sampleWorkLink;

    // Step 9
    @Column(nullable = false)
    private String accountHolderName;

    @Column(nullable = false)
    private String bankName;

    @Column(nullable = false)
    private String accountNumber;

    @Column(nullable = false)
    private String ifscCode;

    private String upiId;

    // Step 10
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
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = LocalDateTime.now();
    }
}