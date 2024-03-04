
package com.psda.movies.moviesapi;

import com.psda.movies.moviesapi.exceptions.GlobalExceptionHandler;
import com.psda.movies.moviesapi.exceptions.InvalidVoteException;
import com.psda.movies.moviesapi.exceptions.ResourceNotFoundException;
import com.psda.movies.moviesapi.models.ErrorDto;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GlobalExceptionHandlerTest {

    @SuppressWarnings("null")
    @Test
    public void testHandleResourceNotFoundException() {
        // Arrange
        ResourceNotFoundException exception = new ResourceNotFoundException("Resource not found", "404", null);
        GlobalExceptionHandler handler = new GlobalExceptionHandler();

        // Act
        ResponseEntity<ErrorDto> response = handler.handleResourceNotFoundException(exception);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("404", response.getBody().getCode());
        assertEquals("Resource not found", response.getBody().getMessage());
    }

    @SuppressWarnings("null")
    @Test
    public void testHandleInvalidVoteException() {
        // Arrange
        InvalidVoteException exception = new InvalidVoteException("Invalid vote", "400", null);
        GlobalExceptionHandler handler = new GlobalExceptionHandler();

        // Act
        ResponseEntity<ErrorDto> response = handler.handleInvalidVoteException(exception);

        // Assert
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("400", response.getBody().getCode());
        assertEquals("Invalid vote", response.getBody().getMessage());
    }
}