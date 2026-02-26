package com.matrimony.servicepage.specification;

import com.matrimony.servicepage.dto.CateringVendorFilterRequest;
import com.matrimony.servicepage.entity.CateringVendor;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CateringVendorSpecification {

    public static Specification<CateringVendor> filter(CateringVendorFilterRequest request) {

        return (Root<CateringVendor> root, CriteriaQuery<?> query, CriteriaBuilder cb) -> {

            List<Predicate> predicates = new ArrayList<>();

               //Budget Range Filter (Flexible Logic)

            if (request.getMinBudgetRange() != null && request.getMaxBudgetRange() != null) {

                predicates.add(
                        cb.and(
                                cb.greaterThanOrEqualTo(root.get("maxBudgetRange"), request.getMinBudgetRange()),
                                cb.lessThanOrEqualTo(root.get("minBudgetRange"), request.getMaxBudgetRange())
                        )
                );

            } else if (request.getMinBudgetRange() != null) {

                BigDecimal budget = request.getMinBudgetRange();

                predicates.add(
                        cb.and(
                                cb.lessThanOrEqualTo(root.get("minBudgetRange"), budget),
                                cb.greaterThanOrEqualTo(root.get("maxBudgetRange"), budget)
                        )
                );

            } else if (request.getMaxBudgetRange() != null) {

                predicates.add(
                        cb.lessThanOrEqualTo(root.get("minBudgetRange"), request.getMaxBudgetRange())
                );
            }

               //State & District

            if (request.getState() != null && !request.getState().isEmpty()) {
                predicates.add(
                        cb.equal(root.get("state"),
                                request.getState())
                );
            }

            if (request.getDistrict() != null && !request.getDistrict().isEmpty()) {
                predicates.add(
                        cb.equal(root.get("district"),
                                request.getDistrict())
                );
            }

               // Cuisines Offered (ElementCollection)

            if (request.getCuisinesOffered() != null && !request.getCuisinesOffered().isEmpty()) {

                Join<Object, Object> cuisineJoin = root.join("cuisinesOffered");

                predicates.add(
                        cuisineJoin.in(request.getCuisinesOffered())
                );

                query.distinct(true);
            }

               // Preferred Locations

            if (request.getPreferredLocations() != null && !request.getPreferredLocations().isEmpty()) {

                Join<Object, Object> locationJoin = root.join("preferredLocations");

                predicates.add(
                        locationJoin.in(request.getPreferredLocations())
                );

                query.distinct(true);
            }

               //Service Type

            if (request.getServiceType() != null && !request.getServiceType().isEmpty()) {

                Join<Object, Object> serviceJoin = root.join("serviceType");

                predicates.add(
                        serviceJoin.in(request.getServiceType())
                );

                query.distinct(true);
            }

               //Special Menus

            if (request.getSpecialMenusAvailable() != null && !request.getSpecialMenusAvailable().isEmpty()) {

                Join<Object, Object> menuJoin = root.join("specialMenusAvailable");

                predicates.add(
                        menuJoin.in(request.getSpecialMenusAvailable())
                );

                query.distinct(true);
            }

               //Boolean Filters

            if (request.getTransportationChargesApplicable() != null) {
                predicates.add(
                        cb.equal(root.get("transportationChargesApplicable"),
                                request.getTransportationChargesApplicable())
                );
            }

            if (request.getServingStaffProvided() != null) {
                predicates.add(
                        cb.equal(root.get("servingStaffProvided"),
                                request.getServingStaffProvided())
                );
            }

            if (request.getUniformedStaff() != null) {
                predicates.add(
                        cb.equal(root.get("uniformedStaff"),
                                request.getUniformedStaff())
                );
            }

            if (request.getFSSAICompliance() != null) {
                predicates.add(
                        cb.equal(root.get("fssaiCompliance"),
                                request.getFSSAICompliance())
                );
            }

            if (request.getWaterSource() != null) {
                predicates.add(
                        cb.equal(root.get("waterSource"),
                                request.getWaterSource())
                );
            }

            if (request.getWasteManagementArranged() != null) {
                predicates.add(
                        cb.equal(root.get("wasteManagementArranged"),
                                request.getWasteManagementArranged())
                );
            }

            if (request.getAdvancePaymentRequired() != null) {
                predicates.add(
                        cb.equal(root.get("advancePaymentRequired"),
                                request.getAdvancePaymentRequired())
                );
            }

               //Business Type

            if (request.getBusinessType() != null && !request.getBusinessType().isBlank()) {
                predicates.add(
                        cb.equal(
                                cb.lower(root.get("businessType")),
                                request.getBusinessType().toLowerCase()
                        )
                );
            }

            // Minimum Years of Experience
            if (request.getYearsOfExperience() != null) {
                predicates.add(
                        cb.greaterThanOrEqualTo(
                                root.get("yearsOfExperience"),
                                request.getYearsOfExperience()
                        )
                );
            }

               //Plate Capacity

            if (request.getMinPlateCapacity() != null) {
                predicates.add(
                        cb.greaterThanOrEqualTo(
                                root.get("minPlateCapacity"),
                                request.getMinPlateCapacity()
                        )
                );
            }

            if (request.getMixPlateCapacity() != null) {
                predicates.add(
                        cb.lessThanOrEqualTo(
                                root.get("maxPlateCapacity"),
                                request.getMixPlateCapacity()
                        )
                );
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}