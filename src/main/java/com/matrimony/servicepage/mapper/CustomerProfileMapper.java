package com.matrimony.servicepage.mapper;

import com.matrimony.servicepage.dto.CustomerProfileResponse;
import com.matrimony.servicepage.entity.CustomerRegistration;

public class CustomerProfileMapper {

    public static CustomerProfileResponse toDto(CustomerRegistration customer) {

        CustomerProfileResponse response = new CustomerProfileResponse();

        // Personal Details
        response.setFullName(customer.getFullName());
        response.setDateOfBirth(customer.getDateOfBirth());
        response.setGender(customer.getGender());
        response.setMaritalStatus(customer.getMaritalStatus());
        response.setReligion(customer.getReligion());
        response.setCaste(customer.getCaste());
        response.setMotherTongue(customer.getMotherTongue());
        response.setBodyType(customer.getBodyType());
        response.setHeight(customer.getHeight());
        response.setWeight(customer.getWeight());
        response.setComplexion(customer.getComplexion());

        // Contact Info
        response.setMobileNumber(customer.getMobileNumber());
        response.setAlternateMobileNumber(customer.getAlternateMobileNumber());
        response.setEmailId(customer.getEmailId());
        response.setAddress(customer.getAddress());
        response.setDistrict(customer.getDistrict());
        response.setState(customer.getState());
        response.setPinCode(customer.getPinCode());

        // Family Details
        response.setFatherName(customer.getFatherName());
        response.setFatherOccupation(customer.getFatherOccupation());
        response.setMotherName(customer.getMotherName());
        response.setMotherOccupation(customer.getMotherOccupation());
        response.setNumberOfSiblings(customer.getNumberOfSiblings());
        response.setFamilType(customer.getFamilType());
        response.setFamilStatus(customer.getFamilStatus());
        response.setFamilyValues(customer.getFamilyValues());

        // Education & Career
        response.setHighestEducation(customer.getHighestEducation());
        response.setUniversity(customer.getUniversity());
        response.setOccupation(customer.getOccupation());
        response.setCompany(customer.getCompany());
        response.setAnnualIncome(customer.getAnnualIncome());
        response.setWorkLocation(customer.getWorkLocation());

        // Wedding Details
        response.setNameOfBride(customer.getNameOfBride());
        response.setAge(customer.getAge());
        response.setBrideReligion(customer.getBrideReligion());
        response.setBrideCast(customer.getBrideCast());
        response.setBrideOccupation(customer.getBrideOccupation());
        response.setBrideEducation(customer.getBrideEducation());
        response.setWeddingDate(customer.getWeddingDate());
        response.setCity(customer.getCity());
        response.setWeddingVenue(customer.getWeddingVenue());
        response.setExpectedNumberOfGuests(customer.getExpectedNumberOfGuests());
        response.setWeddingEventService(customer.getWeddingEventService());
        response.setPackageSelection(customer.getPackageSelection());
        response.setBudgetRange(customer.getBudgetRange());
        response.setSpecialRequirements(customer.getSpecialRequirements());

        return response;
    }
}