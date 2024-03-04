package com.psda.movies.moviesapi.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.psda.movies.moviesapi.models.ErrorDto;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDto> handleResourceNotFoundException(ResourceNotFoundException e) {
        ErrorDto errorDetails = ErrorDto.builder().code(e.getCode()).message(e.getMessage()).build();
        return new ResponseEntity<>(errorDetails, e.getStatus());
    }

    @ExceptionHandler(InvalidVoteException.class)
    public ResponseEntity<ErrorDto> handleInvalidVoteException(InvalidVoteException e) {
        ErrorDto errorDetails = ErrorDto.builder().code(e.getCode()).message(e.getMessage()).build();
        return new ResponseEntity<>(errorDetails, e.getStatus());
    }
}
