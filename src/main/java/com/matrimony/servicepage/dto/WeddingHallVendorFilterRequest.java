package com.matrimony.servicepage.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
public class WeddingHallVendorFilterRequest {

    private List<String> typeOfVenue;
    private BigDecimal minBudgetRange;
    private BigDecimal maxBudgetRange;
    private Integer seatingCapacity;
    private Integer parkingCapacity;
    private Integer numberOfFloors;
    private Integer diningCapacity;
    private List<String> facilitiesAvailable;
    private Integer numberOfRoomsAvailable;
    private Boolean roomType;
    private List<String> eventsAllowed;
    private List<String> timeSlotsAvailable;
    private Boolean inHouseCateringAvailable;
    private Boolean outsideCateringAllowed;
    private Boolean decorationAllowed;
    private Boolean djAllowed;
    private Boolean alcoholAllowed;

}
