package com.matrimony.servicepage.specification;

import com.matrimony.servicepage.dto.DecorationVendorFilterRequest;
import com.matrimony.servicepage.entity.DecorationVendor;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class DecorationVendorSpecification {

    public static Specification<DecorationVendor> filter(DecorationVendorFilterRequest request) {

        return (Root<DecorationVendor> root,
                CriteriaQuery<?> query,
                CriteriaBuilder cb) -> {

            List<Predicate> predicates = new ArrayList<>();

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

            if (request.getTypeOfDecorationServices()!= null && !request.getTypeOfDecorationServices().isEmpty()) {
                Join<DecorationVendor, String> join =
                        root.join("typeOfDecorationServices");
                predicates.add(join.in(request.getTypeOfDecorationServices()));
                query.distinct(true);
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
            if (request.getBusinessType() != null && !request.getBusinessType().isBlank()) {
                predicates.add(cb.equal(
                        cb.lower(root.get("businessType")),
                        request.getBusinessType().toLowerCase()
                ));
            }

            if (request.getDecorationStylesOffered() != null && !request.getDecorationStylesOffered().isEmpty()) {
                Join<DecorationVendor, String> join =
                        root.join("decorationStylesOffered");
                predicates.add(join.in(request.getDecorationStylesOffered()));
                query.distinct(true);
            }

            if (request.getMaterialsUsed() != null && !request.getMaterialsUsed().isEmpty()) {
                Join<DecorationVendor, String> join =
                        root.join("materialsUsed");
                predicates.add(join.in(request.getMaterialsUsed()));
                query.distinct(true);
            }

            if (request.getServicesIncluded() != null && !request.getServicesIncluded().isEmpty()) {
                Join<DecorationVendor, String> join =
                        root.join("servicesIncluded");
                predicates.add(join.in(request.getServicesIncluded()));
                query.distinct(true);
            }

            if (request.getPreferredLocations() != null && !request.getPreferredLocations().isEmpty()) {
                Join<DecorationVendor, String> join =
                        root.join("preferredLocations");
                predicates.add(join.in(request.getPreferredLocations()));
                query.distinct(true);
            }



            // Boolean Field
            if (request.getTransportationChargesApplicable() != null) {
                predicates.add(cb.equal(
                        root.get("transportationChargesApplicable"),
                        request.getTransportationChargesApplicable()
                ));
            }


            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}