package com.matrimony.servicepage.specification;


import com.matrimony.servicepage.dto.BackgroundInvestigationVendorFilterRequest;
import com.matrimony.servicepage.entity.BackgroundInvestigationVendor;
import com.matrimony.servicepage.entity.CateringVendor;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BackgroundInvestigationVendorSpecification {

    public static Specification<BackgroundInvestigationVendor> filter(
            BackgroundInvestigationVendorFilterRequest request) {

        return (Root<BackgroundInvestigationVendor> root, CriteriaQuery<?> query, CriteriaBuilder cb) -> {

            List<Predicate> predicates = new ArrayList<>();

            // Type Of Entity (ElementCollection - List<String>)
            if (request.getTypeOfEntity() != null && !request.getTypeOfEntity().isEmpty()) {
                predicates.add(
                        cb.equal(
                                cb.lower(root.get("typeOfEntity")),
                                request.getTypeOfEntity().toLowerCase()
                        )
                );
            }

            // Year Of Establishment
            if (request.getYearsOfEstablishment() != null) {
                predicates.add(cb.greaterThanOrEqualTo(
                        root.get("yearsOfEstablishment"),
                        request.getYearsOfEstablishment()));
            }

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

            // license Verified
            if (request.getLicenseVerified() != null) {

                Expression<String> license = cb.trim(root.get("privateDetectiveLicenseNumber"));

                if (Boolean.TRUE.equals(request.getLicenseVerified())) {

                    predicates.add(
                            cb.and(
                                    cb.isNotNull(root.get("privateDetectiveLicenseNumber")),
                                    cb.notEqual(license, "")
                            )
                    );

                } else {

                    predicates.add(
                            cb.or(
                                    cb.isNull(root.get("privateDetectiveLicenseNumber")),
                                    cb.equal(license, "")
                            )
                    );
                }
            }

            // States Of Operation (IN)
//            if (request.getStatesOfOperation() != null
//                    && !request.getStatesOfOperation().isEmpty()) {
//
//                List<Predicate> statesPredicates = new ArrayList<>();
//
//                for (String states : request.getStatesOfOperation()) {
//
//                    statesPredicates.add(
//                            cb.like(
//                                    cb.lower(root.get("statesOfOperation")),
//                                    "%"+ states.toLowerCase().trim() +"%"
//                            )
//                    );
//                }

            // state
            if (request.getState() != null && !request.getState().isEmpty()) {
                predicates.add(
                        cb.equal(root.get("state"),
                                request.getState())
                );
            }

            // district
            if (request.getDistrict() != null && !request.getDistrict().isEmpty()) {
                predicates.add(
                        cb.equal(root.get("district"),
                                request.getDistrict())
                );
            }

            // Matrimonial Verification Checks (ElementCollection)
            if (request.getMatrimonialVerificationChecks() != null
                    && !request.getMatrimonialVerificationChecks().isEmpty()) {

                Join<Object, Object> join =
                        root.join("matrimonialVerificationChecks");

                predicates.add(join.in(request.getMatrimonialVerificationChecks()));
            }

            // Regions Covered (LIKE)
            if (request.getRegionsCovered() != null
                    && !request.getRegionsCovered().isBlank()) {

                predicates.add(cb.like(
                        cb.lower(root.get("regionsCovered")),
                        "%" + request.getRegionsCovered().toLowerCase() + "%"
                ));
            }

            // Number Of Field Investigators
            if (request.getNumberOfFieldInvestigators() != null) {
                predicates.add(cb.greaterThanOrEqualTo(
                        root.get("numberOfFieldInvestigators"),
                        request.getNumberOfFieldInvestigators()));
            }

            // Average Turnaround Time
//            if (request.getAverageTurnaroundTime() != null
//                    && !request.getAverageTurnaroundTime().isEmpty()) {
//
//                predicates.add(
//                        cb.like(
//                                cb.lower(root.get("averageTurnaroundTime")),
//                                "%" + request.getAverageTurnaroundTime().toLowerCase() + "%"
//                        )
//                );
//            }

            // yearsOfExperienceInMatrimonialVerification
            if (request.getYearsOfExperienceInMatrimonialVerification() != null
                    && !request.getYearsOfExperienceInMatrimonialVerification().isEmpty()) {

                String value = request.getYearsOfExperienceInMatrimonialVerification()
                        .replace("Years", "")
                        .replace("years", "")
                        .replace("+", "")
                        .trim();

                Integer minYears = Integer.parseInt(value);

                predicates.add(
                        cb.greaterThanOrEqualTo(
                                root.get("yearsOfExperienceInMatrimonialVerification"),
                                minYears
                        )
                );
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }

}
