package com.sapient.TicketBookingSystem.dto;

import lombok.Data;

import java.util.List;

/**
 * @author Rishi Arora
 */
@Data
public class BookingRequest {
    private Long showId;
    private List<String> seats;
}
