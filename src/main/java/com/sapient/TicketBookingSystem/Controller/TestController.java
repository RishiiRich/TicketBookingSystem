package com.sapient.TicketBookingSystem.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Rishi Arora
 */
@RestController
@RequestMapping("/")
public class TestController {

    @GetMapping
    public String home() {
        return "App is up and running";
    }
}
