package iti.jets.marketplace.exceptions.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import iti.jets.marketplace.dtos.ErrorResponse;
import iti.jets.marketplace.exceptions.DataIntegrityViolationException;
import jakarta.servlet.http.HttpServletRequest;

public class DataIntegrityExceptionHandler {
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponse> handleTypeMismatch(DataIntegrityViolationException ex, HttpServletRequest req) {
        String message = String.format("null property that cannot be null");

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(message);
        errorResponse.setStatus(HttpStatus.valueOf(406));
        errorResponse.setCode(406);
        errorResponse.setLocation(req.getRequestURL().toString());

        return new ResponseEntity<>(errorResponse,
                errorResponse.getStatus());
    }
}
