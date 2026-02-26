package com.matrimony.servicepage.specification;


import com.matrimony.servicepage.dto.InvitationVendorFilterRequest;
import com.matrimony.servicepage.entity.InvitationVendor;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
public class InvitationVendorSpecification {

    public static Specification<InvitationVendor> filter(
            InvitationVendorFilterRequest request) {

        return (Root<InvitationVendor> root,
                CriteriaQuery<?> query,
                CriteriaBuilder cb) -> {

            List<Predicate> predicates = new ArrayList<>();

            // typeOfServicesProvided
            if (request.getTypeOfServicesProvided() != null &&
                    !request.getTypeOfServicesProvided().isEmpty()) {

                Join<Object, Object> join =
                        root.join("typeOfServicesProvided");

                predicates.add(join.in(request.getTypeOfServicesProvided()));
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

            // invitationTypesOffered
            if (request.getInvitationTypesOffered() != null &&
                    !request.getInvitationTypesOffered().isEmpty()) {

                Join<Object, Object> join =
                        root.join("invitationTypesOffered");

                predicates.add(join.in(request.getInvitationTypesOffered()));
                query.distinct(true);
            }

            //  printingOptions
            if (request.getPrintingOptions() != null &&
                    !request.getPrintingOptions().isEmpty()) {

                Join<Object, Object> join =
                        root.join("printingOptions");

                predicates.add(join.in(request.getPrintingOptions()));
                query.distinct(true);
            }

            // customizationAvailable
            if (request.getCustomizationAvailable() != null) {
                predicates.add(cb.equal(
                        root.get("customizationAvailable"),
                        request.getCustomizationAvailable()));
            }

            //  typesOfGiftsOffered
            if (request.getTypesOfGiftsOffered() != null &&
                    !request.getTypesOfGiftsOffered().isEmpty()) {

                Join<Object, Object> join =
                        root.join("typesOfGiftsOffered");

                predicates.add(join.in(request.getTypesOfGiftsOffered()));
                query.distinct(true);
            }

            // namePrintingAvailable
            if (request.getNamePrintingAvailable() != null) {
                predicates.add(cb.equal(
                        root.get("namePrintingAvailable"),
                        request.getNamePrintingAvailable()));
            }

            //wrappingIncluded
            if (request.getWrappingIncluded() != null) {
                predicates.add(cb.equal(
                        root.get("wrappingIncluded"),
                        request.getWrappingIncluded()));
            }

            // Invitation Budget Range Filter
            if (request.getInvitationMinPrice() != null && request.getInvitationMaxPrice() != null) {

                predicates.add(
                        cb.and(
                                cb.lessThanOrEqualTo(root.get("invitationMinPrice"), request.getInvitationMaxPrice()),
                                cb.greaterThanOrEqualTo(root.get("invitationMaxPrice"), request.getInvitationMinPrice())
                        )
                );

            } else if (request.getInvitationMinPrice() != null) {

                predicates.add(
                        cb.greaterThanOrEqualTo(root.get("invitationMaxPrice"),
                                request.getInvitationMinPrice())
                );

            } else if (request.getInvitationMaxPrice() != null) {

                predicates.add(
                        cb.lessThanOrEqualTo(root.get("invitationMinPrice"),
                                request.getInvitationMaxPrice())
                );
            }

            // gift Budget Range
            if (request.getGiftMinPrice() != null && request.getGiftMaxPrice() != null) {

                predicates.add(
                        cb.and(
                                cb.greaterThanOrEqualTo(root.get("giftMaxPrice"), request.getGiftMinPrice()),
                                cb.lessThanOrEqualTo(root.get("giftMinPrice"), request.getGiftMaxPrice())
                        )
                );

            } else if (request.getGiftMinPrice()!= null) {

                BigDecimal budget = request.getGiftMinPrice();

                predicates.add(
                        cb.and(
                                cb.lessThanOrEqualTo(root.get("giftMinPrice"), budget),
                                cb.greaterThanOrEqualTo(root.get("giftMaxPrice"), budget)
                        )
                );

            } else if (request.getGiftMaxPrice() != null) {

                predicates.add(
                        cb.lessThanOrEqualTo(root.get("giftMinPrice"), request.getGiftMaxPrice())
                );
            }

            //advancePaymentRequired
            if (request.getAdvancePaymentRequired() != null) {
                predicates.add(cb.equal(
                        root.get("advancePaymentRequired"),
                        request.getAdvancePaymentRequired()));
            }

            // design Approval
            if (request.getDesignApproval() != null) {
                predicates.add(cb.lessThanOrEqualTo(
                        root.get("designApproval"),
                        request.getDesignApproval()));
            }

            // Printing Delivery
            if (request.getPrinting() != null) {
                predicates.add(cb.lessThanOrEqualTo(
                        root.get("printing"),
                        request.getPrinting()));
            }

            // Gift Preparation
            if (request.getGiftPreparation() != null) {
                predicates.add(cb.lessThanOrEqualTo(
                        root.get("giftPreparation"),
                        request.getGiftPreparation()));
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

            // serviceCoverageLocations
            if (request.getServiceCoverageLocations() != null &&
                    !request.getServiceCoverageLocations().isEmpty()) {

                Join<Object, Object> join =
                        root.join("serviceCoverageLocations");

                predicates.add(join.in(request.getServiceCoverageLocations()));
                query.distinct(true);
            }

            //  travelChargesApplicable
            if (request.getTravelChargesApplicable() != null) {
                predicates.add(cb.equal(root.get("travelChargesApplicable"),
                        request.getTravelChargesApplicable()));
            }


            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
