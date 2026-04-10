package com.sapient.TicketBookingSystem.exception;

import com.sapient.TicketBookingSystem.dto.ServiceResponse;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

/**
 * @author Rishi Arora
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ServiceResponse<Object>> handleNotFound(ResourceNotFoundException ex) {

        ServiceResponse<Object> response = ServiceResponse.builder()
                .status(404)
                .message(ex.getMessage())
                .data(null)
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ServiceResponse<Object>> handleBadRequest(BadRequestException ex) {

        ServiceResponse<Object> response = ServiceResponse.builder()
                .status(400)
                .message(ex.getMessage())
                .data(null)
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ServiceResponse<Object>> handleTypeMismatch() {

        ServiceResponse<Object> response = ServiceResponse.builder()
                .status(400)
                .message("Invalid input. Please check date format (YYYY-MM-DD)")
                .data(null)
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ServiceResponse<Object>> handleGeneric(Exception ex) {

        ServiceResponse<Object> response = ServiceResponse.builder()
                .status(500)
                .message("Internal server error")
                .data(null)
                .build();

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}
