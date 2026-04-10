package com.sapient.TicketBookingSystem.Repository;

import com.sapient.TicketBookingSystem.Entity.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Rishi Arora
 */
@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {

    List<Show> findByMovieNameAndCityAndStartTimeBetween(String movieName,
                                                         String city,
                                                         LocalDateTime start,
                                                         LocalDateTime end);

}
