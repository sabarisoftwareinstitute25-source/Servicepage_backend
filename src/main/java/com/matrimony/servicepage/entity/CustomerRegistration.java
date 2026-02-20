package com.matrimony.servicepage.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customer_registration")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerRegistration {

    @Id
    @Column(name = "customer_registration_id", length = 25)
    private String customerRegistrationId;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id", unique = true)
    private Customer customer;

    // Step 1
    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private LocalDate dateOfBirth;

    @Column(nullable = false)
    private String gender;

    @Column(nullable = false)
    private String maritalStatus;

    @Column(nullable = false)
    private String religion;

    private String caste;
    private String motherTongue;
    private String bodyType;
    private String height;
    private Integer weight;
    private String complexion;

    // Step 2
    @Column(nullable = false)
    private Long mobileNumber;

    private Long alternateMobileNumber;

    @Column(nullable = false)
    private String emailId;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String district;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private Integer pinCode;

    // Step 3
    private String fatherName;
    private String fatherOccupation;
    private String motherName;
    private String motherOccupation;
    private String numberOfSiblings;
    private String familType;
    private String familStatus;
    private String familyValues;

    // Step 4
    @Column(nullable = false)
    private String highestEducation;

    private String university;

    @Column(nullable = false)
    private String occupation;

    private String company;
    private Integer annualIncome;
    private String workLocation;

    // Step 5
    @Column(nullable = false)
    private String nameOfBride;

    @Column(nullable = false)
    private Integer age;

    @Column(nullable = false)
    private String brideReligion;

    private String brideCast;

    @Column(nullable = false)
    private String brideOccupation;

    @Column(nullable = false)
    private String brideEducation;

    // Step 6
    @Column(nullable = false)
    private LocalDate weddingDate;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String weddingVenue;

    @Column(nullable = false)
    private Integer expectedNumberOfGuests;

    // Step 7
    @ElementCollection
    @CollectionTable(
            name = "customer_registration_wedding_event_service",
            joinColumns = @JoinColumn(name = "vendor_id")
    )
    @Column(name = "wedding_event_service", nullable = false)
    private List<String> weddingEventService = new ArrayList<>();

    // Step 8
    @Column(nullable = false)
    private String packageSelection;

    @Column(nullable = false)
    private String budgetRange;

    private String specialRequirements;

    // Step 9
    @Column(nullable = false)
    private Boolean acceptedTerms;

    @Column(nullable = false)
    private String signaturePath;

    @Column(nullable = false)
    private LocalDate declarationDate;

    @Column(nullable = false)
    private String place;

    // Audit Fields
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