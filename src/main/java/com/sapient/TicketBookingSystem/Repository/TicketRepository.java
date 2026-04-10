package com.sapient.TicketBookingSystem.Repository;

import com.sapient.TicketBookingSystem.Entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Rishi Arora
 */
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    Optional<Ticket> findByShowIdAndSeatNumberAndBookingStatus(Long showId, String seatNumber, String status);
}
