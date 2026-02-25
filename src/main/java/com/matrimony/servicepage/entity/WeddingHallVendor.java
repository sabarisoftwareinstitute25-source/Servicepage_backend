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
@Table(name = "weddinghall_vendors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WeddingHallVendor {

    @Id
    @Column(name = "weddinghall_vendor_id", nullable = false, length = 30)
    private String weddingHallVendorId;

    @PrePersist
    protected void generateId() {
        if (this.weddingHallVendorId == null || this.weddingHallVendorId.isBlank()) {
            this.weddingHallVendorId = BeanUtil.getBean(IdGeneratorService.class)
                    .generateMonthlyId("WeddingHallVendor",
                            "weddingHallVendorId",
                            "WVF",
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
    private String hallName;

    @Column(nullable = false)
    private String ownerName;

    @ElementCollection
    @CollectionTable(
            name = "weddinghall_vendor_venue",
            joinColumns = @JoinColumn(name = "vendor_id")
    )
    @Column(name = "typeOfVenue", nullable = false)
    private List<String> typeOfVenue = new ArrayList<>();

    private String other;

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

    @Column(nullable = false)
    private String venueAddress;

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
    private Integer yearsInOperation;

    // Step 4
    @Column(nullable = false)
    private Integer seatingCapacity;

    @Column(nullable = false)
    private Integer diningCapacity;

    private Integer parkingCapacity;

    private Integer numberOfFloors;

    @ElementCollection
    @CollectionTable(
            name = "weddinghall_vendor_facilities_available",
            joinColumns = @JoinColumn(name = "vendor_id")
    )
    @Column(name = "facilities_available", nullable = false)
    private List<String> facilitiesAvailable = new ArrayList<>();

    // Step 5
    private Integer numberOfRoomsAvailable;

    @Column(nullable = false)
    private Boolean roomType;

    private String checkInTime;
    private String checkOutTime;

    // Step 6 - Service Coverage

    @ElementCollection
    @CollectionTable(
            name = "weddinghall_vendor_events_allowed",
            joinColumns = @JoinColumn(name = "vendor_id")
    )
    @Column(name = "eventsAllowed", nullable = false)
    private List<String> eventsAllowed = new ArrayList<>();

    @ElementCollection
    @CollectionTable(
            name = "weddinghall_vendor_time_slots_available",
            joinColumns = @JoinColumn(name = "vendor_id")
    )
    @Column(name = "time_slots_available", nullable = false)
    private List<String> timeSlotsAvailable = new ArrayList<>();

    @Column(length = 2000)
    private String specialDescription;

    @ElementCollection
    @CollectionTable(
            name = "weddinghall_vendor_venue_photos",
            joinColumns = @JoinColumn(name = "vendor_id")
    )
    @Column(name = "venue_photos")
    private List<String> venuePhotos = new ArrayList<>();

    @ElementCollection
    @CollectionTable(
            name = "weddinghall_vendor_venue-links",
            joinColumns = @JoinColumn(name = "vendor_id")
    )
    @Column(name = "venue_links")
    private List<String> venueLinks = new ArrayList<>();

    // Step 7
    @Column(nullable = false)
    private Integer morningSlotPrice;

    @Column(nullable = false)
    private Integer eveningSlotPrice;

    private Integer fullDayPrice;
    private Integer securityDeposit;

    @Column(nullable = false)
    private Boolean advanceAmountRequired;

    private String cancellationPolicy;

    // Step 8
    @Column(nullable = false)
    private Boolean inHouseCateringAvailable;

    @Column(nullable = false)
    private Boolean outsideCateringAllowed;

    @Column(nullable = false)
    private boolean decorationAllowed;

    @Column(nullable = false)
    private Boolean djAllowed;

    private String timeLimit;

    @Column(nullable = false)
    private Boolean alcoholAllowed;

    // Step 9
    @Column(name = "website_url", length = 500)
    private String websiteUrl;

    @Column(name = "google_maps_link", length = 500)
    private String googleMapsLink;

    @Column(name = "social_media_links", length = 500)
    private String socialMediaLinks;

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
    public void preUpdate() {
        updatedAt = LocalDateTime.now();
    }
}