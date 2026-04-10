package com.sapient.TicketBookingSystem.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @author Rishi Arora
 */
@Data
@Builder
public class ServiceResponse<T> {
    private int status;
    private String message;
    private T data;
}
