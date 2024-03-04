package com.psda.movies.moviesapi;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import com.psda.movies.moviesapi.exceptions.InvalidVoteException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InvalidVoteExceptionTest {

    @Test
    public void testConstructorAndGetters() {
        // Arrange
        String message = "Invalid vote";
        String code = "INVALID_VOTE";
        HttpStatus status = HttpStatus.BAD_REQUEST;

        // Act
        InvalidVoteException exception = new InvalidVoteException(message, code, status);

        // Assert
        assertEquals(message, exception.getMessage());
        assertEquals(code, exception.getCode());
        assertEquals(status, exception.getStatus());
    }

    @Test
    public void testDefaultConstructor() {
        // Arrange
        String message = "INVALID_VOTE";
        String code = "INVALID_VOTE";
        HttpStatus status = HttpStatus.BAD_REQUEST;

        // Act
        InvalidVoteException exception = new InvalidVoteException(code, code, status);

        // Assert
        assertEquals(message, exception.getMessage());
        assertEquals(code, exception.getCode());
        assertEquals(status, exception.getStatus());
    }

    @Test
    public void testDefaultConstructorWithNullCode() {
        // Arrange
        String message = "Invalid vote";
        String code = "INVALID_VOTE";
        HttpStatus status = HttpStatus.BAD_REQUEST;

        // Act
        InvalidVoteException exception = new InvalidVoteException(message, code, status);

        // Assert
        assertEquals(message, exception.getMessage());
        assertEquals(code, exception.getCode());
        assertEquals(status, exception.getStatus());
    }

    @Test
    public void testDefaultConstructorWithNullStatus() {
        // Arrange
        String message = "Invalid vote";
        String code = "INVALID_VOTE";
        HttpStatus status = HttpStatus.BAD_REQUEST;

        // Act
        InvalidVoteException exception = new InvalidVoteException(message, code, status);

        // Assert
        assertEquals(message, exception.getMessage());
        assertEquals(code, exception.getCode());
        assertEquals(status, exception.getStatus());
    }

    // Test equals and hashCode
    @Test
    public void testEqualsAndHashCode() {
        // Arrange
        InvalidVoteException exception1 = new InvalidVoteException("Invalid vote", "INVALID_VOTE",
                HttpStatus.BAD_REQUEST);
        InvalidVoteException exception2 = new InvalidVoteException("Invalid vote", "INVALID_VOTE",
                HttpStatus.BAD_REQUEST);

        // Act
        boolean result = exception1.equals(exception2);

        // Assert
        assertEquals(exception1.hashCode(), exception2.hashCode());
        assertEquals(true, result);
    }

    // test setcode and setstatus
    @Test
    public void testSetCodeAndStatus() {
        // Arrange
        InvalidVoteException exception = new InvalidVoteException("Invalid vote", "INVALID_VOTE",
                HttpStatus.BAD_REQUEST);
        String code = "INVALID_VOTE";
        HttpStatus status = HttpStatus.BAD_REQUEST;

        // Act
        exception.setCode(code);
        exception.setStatus(status);

        // Assert
        assertEquals(code, exception.getCode());
        assertEquals(status, exception.getStatus());
    }

    // test tostring
    @Test
    public void testToString() {
        // Arrange
        InvalidVoteException exception = new InvalidVoteException("Invalid vote", "INVALID_VOTE",
                HttpStatus.BAD_REQUEST);
        String expected = "InvalidVoteException(code=INVALID_VOTE, status=400 BAD_REQUEST)";

        // Act
        String result = exception.toString();

        // Assert
        assertEquals(expected, result);
    }
}