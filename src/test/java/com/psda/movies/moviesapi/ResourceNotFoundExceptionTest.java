package com.psda.movies.moviesapi;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import com.psda.movies.moviesapi.exceptions.ResourceNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResourceNotFoundExceptionTest {

    @Test
    public void testConstructorAndGetters() {
        // Arrange
        String message = "Resource not found";
        String code = "404";
        HttpStatus status = HttpStatus.NOT_FOUND;

        // Act
        ResourceNotFoundException exception = new ResourceNotFoundException(message, code, status);

        // Assert
        assertEquals(message, exception.getMessage());
        assertEquals(code, exception.getCode());
        assertEquals(status, exception.getStatus());
    }

    @Test
    public void testDefaultConstructor() {
        // Arrange
        String message = "404";
        String code = "404";
        HttpStatus status = HttpStatus.NOT_FOUND;

        // Act
        ResourceNotFoundException exception = new ResourceNotFoundException(code, code, status);

        // Assert
        assertEquals(message, exception.getMessage());
        assertEquals(code, exception.getCode());
        assertEquals(status, exception.getStatus());
    }

    @Test
    public void testDefaultConstructorWithNullCode() {
        // Arrange
        String message = "Resource not found";
        String code = "404";
        HttpStatus status = HttpStatus.NOT_FOUND;

        // Act
        ResourceNotFoundException exception = new ResourceNotFoundException(message, code, status);

        // Assert
        assertEquals(message, exception.getMessage());
        assertEquals(code, exception.getCode());
        assertEquals(status, exception.getStatus());
    }

    @Test
    public void testDefaultConstructorWithNullStatus() {
        // Arrange
        String message = "404";
        String code = "404";
        HttpStatus status = HttpStatus.NOT_FOUND;

        // Act
        ResourceNotFoundException exception = new ResourceNotFoundException(code, code, status);

        // Assert
        assertEquals(message, exception.getMessage());
        assertEquals(code, exception.getCode());
        assertEquals(status, exception.getStatus());
    }

    // test equals and hashcode
    @Test
    public void testEqualsAndHashCode() {
        // Arrange
        String message = "Resource not found";
        String code = "404";
        HttpStatus status = HttpStatus.NOT_FOUND;

        // Act
        ResourceNotFoundException exception1 = new ResourceNotFoundException(message, code, status);
        ResourceNotFoundException exception2 = new ResourceNotFoundException(message, code, status);

        // Assert
        assertEquals(exception1, exception2);
        assertEquals(exception1.hashCode(), exception2.hashCode());
    }

    @Test
    public void testEqualsAndHashCodeWithDifferentMessage() {
        // Arrange
        String message1 = "Resource not found";
        String message2 = "Resource not found 2";
        String code = "404";
        HttpStatus status = HttpStatus.NOT_FOUND;

        // Act
        ResourceNotFoundException exception1 = new ResourceNotFoundException(message1, code, status);
        ResourceNotFoundException exception2 = new ResourceNotFoundException(message2, code, status);

        // Assert
        assertEquals(exception1, exception2);
        assertEquals(exception1.hashCode(), exception2.hashCode());
    }

    // test setters
    @Test
    public void testSetters() {
        // Arrange
        String message = "Resource not found";
        String code = "404";
        HttpStatus status = HttpStatus.NOT_FOUND;

        // Act
        ResourceNotFoundException exception = new ResourceNotFoundException(message, code, status);
        String newMessage = "Resource not found";
        String newCode = "500";
        HttpStatus newStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        exception.setCode(newCode);
        exception.setStatus(newStatus);

        // Assert
        assertEquals(newMessage, exception.getMessage());
        assertEquals(newCode, exception.getCode());
        assertEquals(newStatus, exception.getStatus());
    }

    @Test
    public void testConstructorWithCodeAndStatus() {
        // Arrange
        String code = "404";
        HttpStatus status = HttpStatus.NOT_FOUND;

        // Act
        ResourceNotFoundException exception = new ResourceNotFoundException(code, status);

        // Assert
        assertEquals(code, exception.getMessage());
        assertEquals(code, exception.getCode());
        assertEquals(status, exception.getStatus());
    }

    // test setCode and setStatus
    @Test
    public void testSetCodeAndStatus() {
        // Arrange
        String message = "Resource not found";
        String code = "404";
        HttpStatus status = HttpStatus.NOT_FOUND;

        // Act
        ResourceNotFoundException exception = new ResourceNotFoundException(message, code, status);
        String newCode = "500";
        HttpStatus newStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        exception.setCode(newCode);
        exception.setStatus(newStatus);

        // Assert
        assertEquals(message, exception.getMessage());
        assertEquals(newCode, exception.getCode());
        assertEquals(newStatus, exception.getStatus());
    }

}