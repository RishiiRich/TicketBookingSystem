package com.sapient.TicketBookingSystem.Entity;

import com.sapient.TicketBookingSystem.BookingStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Rishi Arora
 */
@Entity
@Getter
@Setter
public class Ticket {
    @Id
    @GeneratedValue
    private Long tickedId;
    private Long showId;
    private String seatNumber;
    @Enumerated(EnumType.STRING)
    private BookingStatus bookingStatus;
}
