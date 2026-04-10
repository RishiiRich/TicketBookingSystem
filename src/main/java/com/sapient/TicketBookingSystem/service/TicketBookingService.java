package com.sapient.TicketBookingSystem.service;

import com.sapient.TicketBookingSystem.BookingStatus;
import com.sapient.TicketBookingSystem.Entity.Show;
import com.sapient.TicketBookingSystem.Entity.Ticket;
import com.sapient.TicketBookingSystem.Repository.ShowRepository;
import com.sapient.TicketBookingSystem.Repository.TicketRepository;
import com.sapient.TicketBookingSystem.dto.BookingRequest;
import com.sapient.TicketBookingSystem.dto.EventResponse;
import com.sapient.TicketBookingSystem.exception.ResourceNotFoundException;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Rishi Arora
 */
@Service
public class TicketBookingService {

    @Autowired
    private ShowRepository showRepository;
    @Autowired
    private TicketRepository ticketRepository;

    public List<EventResponse> getTheatreDetails(String movie, String city, LocalDate date){

        LocalDateTime start = date.atStartOfDay();
        LocalDateTime end = date.atTime(23, 59);

        List<Show> showsResult = showRepository.findByMovieNameAndCityAndStartTimeBetween(movie, city, start,end);

        return showsResult.stream()
                .map(show -> new EventResponse(
                        show.getTheatreName(),
                        show.getMovieName(),
                        show.getCity(),
                        show.getStartTime().toLocalTime().toString(),
                        show.getPrice(),
                        getOffers(show.getStartTime())
                )).collect(Collectors.toList());
    }

    public String bookTickets(BookingRequest request) throws BadRequestException {

        for (String seat : request.getSeats()) {

            Ticket ticket = ticketRepository
                    .findByShowIdAndSeatNumberAndBookingStatus(request.getShowId(), seat,
                            String.valueOf(BookingStatus.AVAILABLE))
                    .orElseThrow(() -> new ResourceNotFoundException("Seat not found: " + seat));

            ticket.setBookingStatus(BookingStatus.BOOKED);
            ticketRepository.save(ticket);
        }

        return "Booking successful";
    }


    private List<String> getOffers(LocalDateTime startTime) {
        List<String> offers = new ArrayList<>();
        offers.add("50% discount on 3rd ticket");
        int hour = startTime.getHour();
        if (hour >= 12 && hour <= 17) {
            offers.add("20% discount on afternoon show");
        }
        return offers;
    }
}
