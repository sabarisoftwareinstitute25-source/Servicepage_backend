package com.matrimony.servicepage.specification;


import com.matrimony.servicepage.dto.PhotographyVendorFilterRequest;
import com.matrimony.servicepage.dto.StylingVendorFilterRequest;
import com.matrimony.servicepage.entity.PhotographyVendor;
import com.matrimony.servicepage.entity.StylingVendor;
import jakarta.persistence.criteria.Join;
import org.springframework.data.jpa.domain.Specification;

import jakarta.persistence.criteria.Predicate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
public class StylingVendorSpecification {

    public static Specification<StylingVendor> filter(
            StylingVendorFilterRequest request) {

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

            // bridalMakeupStyles
            if (request.getBridalMakeupStyles() != null && !request.getBridalMakeupStyles().isEmpty()) {
                Join<Object, Object> bridalJoin = root.join("bridalMakeupStyles");
                predicates.add(bridalJoin.in(request.getBridalMakeupStyles()));
            }

            // groomStylingServices
            if (request.getGroomStylingServices() != null && !request.getGroomStylingServices().isEmpty()) {
                Join<Object, Object> groomJoin = root.join("groomStylingServices");
                predicates.add(groomJoin.in(request.getGroomStylingServices()));
            }

            // productsUsed
            if (request.getProductsUsed() != null && !request.getProductsUsed().isEmpty()) {
                Join<Object, Object> productJoin = root.join("productsUsed");
                predicates.add(productJoin.in(request.getProductsUsed()));
            }

            // Business Type
            if (request.getBusinessType() != null && !request.getBusinessType().isEmpty()) {
                predicates.add(
                        cb.equal(root.get("businessType"),
                                request.getBusinessType())
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

            // ownMakeupKit
            if (request.getOwnMakeupKit() != null) {
                predicates.add(cb.equal(root.get("ownMakeupKit"),
                        request.getOwnMakeupKit()));
            }

            // backupArtistAvailable
            if (request.getBackupArtistAvailable() != null) {
                predicates.add(cb.equal(root.get("backupArtistAvailable"),
                        request.getBackupArtistAvailable()));
            }

            //  hygieneKitsUsed
            if (request.getHygieneKitsUsed() != null) {
                predicates.add(cb.equal(root.get("hygieneKitsUsed"),
                        request.getHygieneKitsUsed()));
            }

            // patchTestAvailable
            if (request.getPatchTestAvailable() != null) {
                predicates.add(cb.equal(root.get("patchTestAvailable"),
                        request.getPatchTestAvailable()));
            }

            // travelChargesApplicable
            if (request.getTravelChargesApplicable() != null) {
                predicates.add(cb.equal(root.get("travelChargesApplicable"),
                        request.getTravelChargesApplicable()));
            }

            // advancePaymentRequired
            if (request.getAdvancePaymentRequired() != null) {
                predicates.add(cb.equal(root.get("advancePaymentRequired"),
                        request.getAdvancePaymentRequired()));
            }

            if (request.getGst() != null) {
                predicates.add(
                        request.getGst()
                                ? cb.isNotNull(root.get("gstNumber"))
                                : cb.isNull(root.get("gstNumber"))
                );
            }

            if (request.getPan() != null) {
                predicates.add(
                        request.getPan()
                                ? cb.isNotNull(root.get("panNumber"))
                                : cb.isNull(root.get("panNumber"))
                );
            }


            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
