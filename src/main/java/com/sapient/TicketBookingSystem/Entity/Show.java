package com.sapient.TicketBookingSystem.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author Rishi Arora
 */
@Getter
@Setter
@Entity
@Table(name = "SHOWS")
public class Show {
    @Id
    @GeneratedValue
    private Long showId;
    private String movieName;
    private String theatreName;
    private String city;
    private LocalDateTime startTime;
    private double price;

}
