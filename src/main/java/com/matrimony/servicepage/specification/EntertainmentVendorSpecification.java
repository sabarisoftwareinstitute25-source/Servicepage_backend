package com.matrimony.servicepage.specification;

import com.matrimony.servicepage.dto.EntertainmentVendorFilterRequest;
import com.matrimony.servicepage.entity.EntertainmentVendor;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
public class EntertainmentVendorSpecification {

    public static Specification<EntertainmentVendor> filter(
            EntertainmentVendorFilterRequest request) {

        return (Root<EntertainmentVendor> root,
                CriteriaQuery<?> query,
                CriteriaBuilder cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            //  Type of Entertainment Services (List<String>)
            if (request.getTypeOfEntertainmentServices() != null &&
                    !request.getTypeOfEntertainmentServices().isEmpty()) {

                Join<Object, Object> join =
                        root.join("typeOfEntertainmentServices");

                predicates.add(join.in(request.getTypeOfEntertainmentServices()));

                query.distinct(true);
            }

            // Budget Range
            if (request.getMinBudgetRange() != null && request.getMaxBudgetRange() != null) {

                predicates.add(
                        cb.and(
                                cb.greaterThanOrEqualTo(root.get("maxBudgetRange"), request.getMinBudgetRange()),
                                cb.lessThanOrEqualTo(root.get("minBudgetRange"), request.getMaxBudgetRange())
                        )
                );

            } else if (request.getMinBudgetRange()!= null) {

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

            // Business Type
            if (request.getBusinessType() != null && !request.getBusinessType().isBlank()) {
                predicates.add(cb.equal(
                        cb.lower(root.get("businessType")),
                        request.getBusinessType().toLowerCase()
                ));
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

            if (request.getEventsCovered() != null &&
                    !request.getEventsCovered().isEmpty()) {

                Join<Object, Object> join =
                        root.join("eventsCovered");

                predicates.add(join.in(request.getEventsCovered()));

                query.distinct(true);
            }


            //  Typical Performance Duration
            if (request.getTypicalPerformanceDuration() != null) {
                predicates.add(cb.equal(
                        root.get("typicalPerformanceDuration"),
                        request.getTypicalPerformanceDuration()));
            }

            if (request.getCustomPerformancesAvailable() != null) {
                predicates.add(cb.equal(root.get("customPerformancesAvailable"),
                        request.getCustomPerformancesAvailable()));
            }

            if (request.getSoundSystemProvided() != null) {
                predicates.add(cb.equal(root.get("soundSystemProvided"),
                        request.getSoundSystemProvided()));
            }

            if (request.getLightingSetupProvided() != null) {
                predicates.add(cb.equal(root.get("lightingSetupProvided"),
                        request.getLightingSetupProvided()));
            }

            if (request.getSpecialEffects() != null) {
                predicates.add(cb.equal(root.get("specialEffects"),
                        request.getSpecialEffects()));
            }

            if (request.getPowerRequirement() != null) {
                predicates.add(cb.lessThanOrEqualTo(
                        root.get("powerRequirement"),
                        request.getPowerRequirement()
                ));
            }

            if (request.getBackupEquipmentAvailable() != null) {
                predicates.add(cb.equal(root.get("backupEquipmentAvailable"),
                        request.getBackupEquipmentAvailable()));
            }

            // Number of Performers
            if (request.getNumberOfPerformers() != null) {
                predicates.add(cb.greaterThanOrEqualTo(
                        root.get("numberOfPerformers"),
                        request.getNumberOfPerformers()
                ));
            }

            if (request.getUniform() != null) {
                predicates.add(cb.equal(root.get("uniform"),
                        request.getUniform()));
            }

            if (request.getSetup() != null) {
                predicates.add(cb.equal(root.get("setup"),
                        request.getSetup()));
            }

            if (request.getPreferredLocations() != null &&
                    !request.getPreferredLocations().isEmpty()) {

                Join<Object, Object> join =
                        root.join("preferredLocations");

                predicates.add(join.in(request.getPreferredLocations()));

                query.distinct(true);
            }

            if (request.getAccommodationChargesApplicable() != null) {
                predicates.add(cb.equal(root.get("accommodationChargesApplicable"),
                        request.getAccommodationChargesApplicable()));
            }

            if (request.getTimeRestrictionsAware() != null) {
                predicates.add(cb.equal(root.get("timeRestrictionsAware"),
                        request.getTimeRestrictionsAware()));
            }

            if (request.getAdvancePaymentRequired() != null) {
                predicates.add(cb.equal(root.get("advancePaymentRequired"),
                        request.getAdvancePaymentRequired()));
            }

            // Overtime Charges
            if (request.getOvertimeCharges() != null && !request.getOvertimeCharges().isEmpty()) {
                predicates.add(cb.equal(root.get("overtimeCharges"),
                        request.getOvertimeCharges()));
            }

            return cb.and(predicates.toArray(new Predicate[0]));

        };


    }
}