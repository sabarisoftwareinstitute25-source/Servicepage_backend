package com.matrimony.servicepage.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

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

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "vendor_id", nullable = false, unique = true)
    private Vendor vendor;

    // Step 1
    @Column(nullable = false)
    private String hallName;

    @Column(nullable = false)
    private String ownerName;

    @Column(name = "type_of_venue", columnDefinition = "TEXT",nullable = false)
    private List<String> typeOfVenue = new ArrayList<>();

    private String other;

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

    @Column(name = "facilities_available", columnDefinition = "TEXT",nullable = false)
    private List<String> facilitiesAvailable = new ArrayList<>();

    // Step 5
    private Integer numberOfRoomsAvailable;

    @Column(nullable = false)
    private Boolean roomType;

    private String checkInTime;
    private String checkOutTime;

    // Step 6 - Service Coverage

    @Column(name = "events_allowed", columnDefinition = "TEXT",nullable = false)
    private List<String> eventsAllowed = new ArrayList<>();

    @Column(name = "time_slots_available", columnDefinition = "TEXT",nullable = false)
    private List<String> timeSlotsAvailable = new ArrayList<>();

    @Column(length = 2000)
    private String specialDescription;

    @Column(name = "venue_photos", columnDefinition = "TEXT")
    private List<String> venuePhotos = new ArrayList<>();

    @Column(name = "venue_links", columnDefinition = "TEXT")
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
    private String alcoholAllowed;

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

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = LocalDateTime.now();
    }
}