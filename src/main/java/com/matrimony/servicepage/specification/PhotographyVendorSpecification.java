package com.matrimony.servicepage.specification;

import com.matrimony.servicepage.dto.PhotographyVendorFilterRequest;
import com.matrimony.servicepage.entity.PhotographyVendor;
import jakarta.persistence.criteria.Join;
import org.springframework.data.jpa.domain.Specification;

import jakarta.persistence.criteria.Predicate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PhotographyVendorSpecification {

    public static Specification<PhotographyVendor> filter(
            PhotographyVendorFilterRequest request) {

        return (root, query, cb) -> {

            List<Predicate> predicates = new ArrayList<>();

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

            // State
            if (request.getState() != null && !request.getState().isEmpty()) {
                predicates.add(
                        cb.equal(root.get("state"),
                                request.getState())
                );
            }

            // District
            if (request.getDistrict() != null && !request.getDistrict().isEmpty()) {
                predicates.add(
                        cb.equal(root.get("district"),
                                request.getDistrict())
                );
            }

            // Preferred Locations (LIKE search)
            if (request.getPreferredWeddingLocations() != null &&
                    !request.getPreferredWeddingLocations().isEmpty()) {

                Join<Object, Object> join = root.join("preferredWeddingLocations");

                predicates.add(
                        join.in(request.getPreferredWeddingLocations())
                );

                query.distinct(true); // important to avoid duplicate results
            }

            // Travel Charges Applicable
            if (request.getTravelChargesApplicable() != null) {
                predicates.add(
                        cb.equal(root.get("travelChargesApplicable"),
                                request.getTravelChargesApplicable())
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

            // Business Type
            if (request.getBusinessType() != null && !request.getBusinessType().isEmpty()) {
                predicates.add(
                        cb.equal(root.get("businessType"),
                                request.getBusinessType())
                );
            }

            // Photo Delivery Days (max allowed days)
            if (request.getPhotoDelivery() != null) {
                predicates.add(
                        cb.lessThanOrEqualTo(
                                root.get("photoDelivery"),
                                request.getPhotoDelivery()
                        )
                );
            }

            // Video Delivery Days
            if (request.getVideoDelivery() != null) {
                predicates.add(
                        cb.lessThanOrEqualTo(
                                root.get("videoDelivery"),
                                request.getVideoDelivery()
                        )
                );
            }

            // Album Delivery Days
            if (request.getAlbumDelivery() != null) {
                predicates.add(
                        cb.lessThanOrEqualTo(
                                root.get("albumDelivery"),
                                request.getAlbumDelivery()
                        )
                );
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}