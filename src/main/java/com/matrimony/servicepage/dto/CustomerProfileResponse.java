package com.matrimony.servicepage.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class CustomerProfileResponse {

    // personal details
    private String fullName;
    private LocalDate dateOfBirth;
    private String gender;
    private String maritalStatus;
    private String religion;
    private String caste;
    private String motherTongue;
    private String bodyType;
    private String height;
    private Integer weight;
    private String complexion;

    // contact information
    private Long mobileNumber;
    private Long alternateMobileNumber;
    private String emailId;
    private String address;
    private String district;
    private String state;
    private Integer pinCode;

    // family details
    private String fatherName;
    private String fatherOccupation;
    private String motherName;
    private String motherOccupation;
    private String numberOfSiblings;
    private String familType;
    private String familStatus;
    private String familyValues;

    // education & career
    private String highestEducation;
    private String university;
    private String occupation;
    private String company;
    private Integer annualIncome;
    private String workLocation;


    private String nameOfBride;
    private Integer age;
    private String brideReligion;
    private String brideCast;
    private String brideOccupation;
    private String brideEducation;
    private LocalDate weddingDate;
    private String city;
    private String weddingVenue;
    private Integer expectedNumberOfGuests;
    private List<String> weddingEventService;
    private String packageSelection;
    private String budgetRange;
    private String specialRequirements;

}
