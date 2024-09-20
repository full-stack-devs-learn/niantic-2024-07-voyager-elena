package com.niantic.services;

import com.niantic.models.HttpError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGlobalException(Exception ex, WebRequest request) {
        if (ex instanceof ErrorResponse && ((ErrorResponse) ex).getStatusCode() == HttpStatus.NOT_FOUND) {
            // all 404 errors
            HttpError error = new HttpError(HttpStatus.NOT_FOUND.value(),
                    HttpStatus.NOT_FOUND.toString(),
                    "The requested resource was not found.");

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
        } else {
            // all other errors
            HttpError error = new HttpError(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    HttpStatus.INTERNAL_SERVER_ERROR.toString(),
                    "Oops something went wrong");

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
        }
    }

}
