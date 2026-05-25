package com.HostelRoomAllotmentApplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice

public class GlobalExceptionHandler {

    // RESOURCE NOT FOUND
    @ExceptionHandler(ResourceNotFoundException.class)

    public ResponseEntity<String> handleResourceNotFound(

            ResourceNotFoundException ex
    ) {

        return new ResponseEntity<>(

                ex.getMessage(),

                HttpStatus.NOT_FOUND
        );
    }



    // GENERAL EXCEPTION
    @ExceptionHandler(Exception.class)

    public ResponseEntity<String> handleGeneralException(

            Exception ex
    ) {

        return new ResponseEntity<>(

                ex.getMessage(),

                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}