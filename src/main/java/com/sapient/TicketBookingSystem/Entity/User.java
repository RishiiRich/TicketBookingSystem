package com.sapient.TicketBookingSystem.Entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Rishi Arora
 */
@Getter
@Setter
//@Entity
public class User {
    private int userId;
    private String name;
    private String email;
    private String phone_no;
}
