package com.matrimony.servicepage.specification;

import com.matrimony.servicepage.dto.WeddingHallVendorFilterRequest;
import com.matrimony.servicepage.entity.WeddingHallVendor;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class WeddingHallVendorSpecification {

    public static Specification<WeddingHallVendor> filter(WeddingHallVendorFilterRequest request) {

        return (Root<WeddingHallVendor> root,
                CriteriaQuery<?> query,
                CriteriaBuilder cb) -> {

            List<Predicate> predicates = new ArrayList<>();

            // Type Of Venue
            if (request.getTypeOfVenue() != null && !request.getTypeOfVenue().isEmpty()) {
                Join<WeddingHallVendor, String> join =
                        root.join("typeOfVenue");
                predicates.add(join.in(request.getTypeOfVenue()));
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

            // Seating Capacity
            if (request.getSeatingCapacity() != null) {
                predicates.add(cb.greaterThanOrEqualTo(
                        root.get("seatingCapacity"),
                        request.getSeatingCapacity()));
            }

            // Parking Capacity
            if (request.getParkingCapacity() != null) {
                predicates.add(cb.greaterThanOrEqualTo(
                        root.get("parkingCapacity"),
                        request.getParkingCapacity()));
            }

            // Number of Floors
            if (request.getNumberOfFloors() != null) {
                predicates.add(cb.greaterThanOrEqualTo(
                        root.get("numberOfFloors"),
                        request.getNumberOfFloors()));
            }

            // Dining Capacity
            if (request.getDiningCapacity() != null) {
                predicates.add(cb.greaterThanOrEqualTo(
                        root.get("diningCapacity"),
                        request.getDiningCapacity()));
            }

            // Facilities Available
            if (request.getFacilitiesAvailable() != null && !request.getFacilitiesAvailable().isEmpty()) {
                Join<WeddingHallVendor, String> join =
                        root.join("facilitiesAvailable");
                predicates.add(join.in(request.getFacilitiesAvailable()));
                query.distinct(true);
            }

            // Number of Rooms Available
            if (request.getNumberOfRoomsAvailable() != null) {
                predicates.add(cb.greaterThanOrEqualTo(
                        root.get("numberOfRoomsAvailable"),
                        request.getNumberOfRoomsAvailable()));
            }

            // Room Type
            if (request.getRoomType() != null) {
                predicates.add(cb.equal(
                        root.get("roomType"),
                        request.getRoomType()));
            }

            // Events Allowed
            if (request.getEventsAllowed() != null && !request.getEventsAllowed().isEmpty()) {
                Join<WeddingHallVendor, String> join =
                        root.join("eventsAllowed");
                predicates.add(join.in(request.getEventsAllowed()));
                query.distinct(true);
            }


            // Time Slots
            if (request.getTimeSlotsAvailable() != null && !request.getTimeSlotsAvailable().isEmpty()) {
                Join<WeddingHallVendor, String> join =
                        root.join("timeSlotsAvailable");
                predicates.add(join.in(request.getTimeSlotsAvailable()));
                query.distinct(true);
            }
            // In-house Catering
            if (request.getInHouseCateringAvailable() != null) {
                predicates.add(cb.equal(
                        root.get("inHouseCateringAvailable"),
                        request.getInHouseCateringAvailable()));
            }

            // Outside Catering Allowed
            if (request.getOutsideCateringAllowed() != null) {
                predicates.add(cb.equal(
                        root.get("outsideCateringAllowed"),
                        request.getOutsideCateringAllowed()));
            }

            // Decoration Allowed
            if (request.getDecorationAllowed() != null) {
                predicates.add(cb.equal(
                        root.get("decorationAllowed"),
                        request.getDecorationAllowed()));
            }

            // DJ Allowed
            if (request.getDjAllowed() != null) {
                predicates.add(cb.equal(
                        root.get("djAllowed"),
                        request.getDjAllowed()));
            }

            // Alcohol Allowed
            if (request.getAlcoholAllowed() != null) {
                predicates.add(cb.equal(
                        root.get("alcoholAllowed"),
                        request.getAlcoholAllowed()));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}