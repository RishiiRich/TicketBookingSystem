package com.sapient.TicketBookingSystem.Controller;

import com.sapient.TicketBookingSystem.dto.BookingRequest;
import com.sapient.TicketBookingSystem.dto.EventResponse;
import com.sapient.TicketBookingSystem.dto.ServiceResponse;
import com.sapient.TicketBookingSystem.exception.ResourceNotFoundException;
import com.sapient.TicketBookingSystem.service.TicketBookingService;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Rishi Arora
 */
@RestController
@RequestMapping("/event")
public class TicketBookingController {

    @Autowired
    private TicketBookingService ticketBookingService;

    @GetMapping("/search")
    public ResponseEntity<ServiceResponse<List<EventResponse>>> getEventDetails(@RequestParam String movie,
                                                                               @RequestParam String city,
                                                                               @RequestParam
                                                                               @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                                                               LocalDate date) throws BadRequestException {

        if (movie == null || movie.isBlank()) {
            throw new BadRequestException("Movie name is required");
        }

        if (city == null || city.isBlank()) {
            throw new BadRequestException("City is required");
        }

        if (date == null) {
            throw new BadRequestException("Date is required");
        }

        List<EventResponse> response = ticketBookingService.getTheatreDetails(movie,city,date);

        if (response.isEmpty()) {
            throw new ResourceNotFoundException("No Data found");
        }
        return ResponseEntity.ok(
                ServiceResponse.<List<EventResponse>>builder()
                        .status(200)
                        .message(null)
                        .data(response)
                        .build()
        );
    }

    @PostMapping("/book")
    public ResponseEntity<String> bookEvent(@RequestBody BookingRequest request) throws BadRequestException {

        if (request.getShowId() == null || request.getSeats() == null || request.getSeats().isEmpty()) {
            throw new BadRequestException("Invalid booking request");
        }

        String response = ticketBookingService.bookTickets(request);

        return ResponseEntity.ok(response);
    }
}
