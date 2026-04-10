package com.sapient.TicketBookingSystem.exception;

/**
 * @author Rishi Arora
 */
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message){
        super(message);
    }
}
