package com.sapient.TicketBookingSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author Rishi Arora
 */
@Data
@AllArgsConstructor
public class EventResponse {
    private String theatreName;
    private String movieName;
    private String city;
    private String time;
    private double price;
    private List<String> offers;
}
