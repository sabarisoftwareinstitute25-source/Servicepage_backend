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
@Table(name = "invitation_gift_vendors") // '&' removed (invalid in table name)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InvitationVendor {

    @Id
    @Column(name = "invitation_vendor_id", nullable = false, length = 30)
    private String invitationVendorId;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "vendor_id", nullable = false, unique = true)
    private Vendor vendor;

    // Step 1
    @Column(nullable = false)
    private String vendorName;

    @Column(nullable = false)
    private String contactPersonName;

    @ElementCollection
    @CollectionTable(name = "invitation_services",
            joinColumns = @JoinColumn(name = "invitation_vendor_id"))
    @Column(name = "type_of_services_provided", nullable = false)
    private List<String> typeOfServicesProvided = new ArrayList<>();

    private String other;

    // Step 2
    @Column(nullable = false)
    private String mobileNumber;

    private String alternateMobileNumber;

    @Column(nullable = false)
    private String emailId;

    @Column(nullable = false)
    private String shopAddress;

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
    @CollectionTable(name = "invitation_types_offered_table",
            joinColumns = @JoinColumn(name = "invitation_vendor_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "invitation_types_offered", nullable = false)
    private List<InvitationTypesOffered> invitationTypesOffered = new ArrayList<>();

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "invitation_printing_options",
            joinColumns = @JoinColumn(name = "invitation_vendor_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "printing_options", nullable = false)
    private List<PrintingOptions> printingOptions = new ArrayList<>();

    @Column(nullable = false)
    private Integer minimumOrderQuantity;

    @Column(nullable = false)
    private Boolean customizationAvailable;

    // Step 5
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "invitation_types_of_gifts",
            joinColumns = @JoinColumn(name = "invitation_vendor_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "types_of_gifts_offered", nullable = false)
    private List<TypesOfGiftsOffered> typesOfGiftsOffered = new ArrayList<>();

    @Column(nullable = false)
    private Integer minimumOrderQuantityForGifts;

    @Column(nullable = false)
    private Boolean namePrintingAvailable;

    @Column(nullable = false)
    private Boolean wrappingIncluded;

    // Step 6
    @Column(nullable = false)
    private Integer invitationMinPrice;

    @Column(nullable = false)
    private Integer invitationMaxPrice;

    @Column(nullable = false)
    private Integer giftMinPrice;

    @Column(nullable = false)
    private Integer giftMaxPrice;

    @Column(nullable = false)
    private Boolean advancePaymentRequired;

    @Column(nullable = false)
    private String balancePaymentTerms;

    // Step 7
    @Column(nullable = false)
    private Integer designApproval;

    @Column(nullable = false)
    private Integer printingDelivery;

    @Column(nullable = false)
    private Integer giftPreparation;

    // Step 8
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "invitation_preferred_locations",
            joinColumns = @JoinColumn(name = "invitation_vendor_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "location", nullable = false)
    private List<PreferredLocation> preferredLocations = new ArrayList<>();

    @Column(nullable = false)
    private Boolean travelChargesApplicable;

    @Column(columnDefinition = "TEXT")
    private String specialDescription;

    @ElementCollection
    @CollectionTable(name = "invitation_photos",
            joinColumns = @JoinColumn(name = "invitation_vendor_id"))
    @Column(name = "photo_url")
    private List<String> workPhotos = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "invitation_work_portfolio",
            joinColumns = @JoinColumn(name = "invitation_vendor_id"))
    @Column(name = "work_portfolio")
    private List<String> workPortfolio = new ArrayList<>();

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
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}