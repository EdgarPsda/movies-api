package com.psda.movies.moviesapi;

import org.junit.jupiter.api.Test;

import com.psda.movies.moviesapi.models.ErrorDto;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ErrorDtoTest {

    @Test
    public void testGetCode() {
        // Arrange
        String code = "ERROR_CODE";
        ErrorDto errorDto = ErrorDto.builder().code(code).build();

        // Act
        String result = errorDto.getCode();

        // Assert
        assertEquals(code, result);
    }

    @Test
    public void testGetMessage() {
        // Arrange
        String message = "Error message";
        ErrorDto errorDto = ErrorDto.builder().message(message).build();

        // Act
        String result = errorDto.getMessage();

        // Assert
        assertEquals(message, result);
    }

    @Test
    public void testBuilder() {
        // Arrange
        String code = "ERROR_CODE";
        String message = "Error message";

        // Act
        ErrorDto errorDto = ErrorDto.builder().code(code).message(message).build();

        // Assert
        assertEquals(code, errorDto.getCode());
        assertEquals(message, errorDto.getMessage());
    }

    @Test
    public void testEquals() {
        // Arrange
        ErrorDto errorDto1 = ErrorDto.builder().code("ERROR_CODE").message("Error message").build();
        ErrorDto errorDto2 = ErrorDto.builder().code("ERROR_CODE").message("Error message").build();

        // Act and Assert
        assertEquals(errorDto1, errorDto2);
    }

    @Test
    public void testHashCode() {
        // Arrange
        ErrorDto errorDto1 = ErrorDto.builder().code("ERROR_CODE").message("Error message").build();
        ErrorDto errorDto2 = ErrorDto.builder().code("ERROR_CODE").message("Error message").build();

        // Act and Assert
        assertEquals(errorDto1.hashCode(), errorDto2.hashCode());
    }

    @Test
    public void testToString() {
        // Arrange
        ErrorDto errorDto = ErrorDto.builder().code("ERROR_CODE").message("Error message").build();

        // Act
        String result = errorDto.toString();

        // Assert
        assertEquals("ErrorDto(code=ERROR_CODE, message=Error message)", result);
    }

    @Test
    public void testNoArgsConstructor() {
        // Act
        ErrorDto errorDto = new ErrorDto();

        // Assert
        assertEquals(null, errorDto.getCode());
        assertEquals(null, errorDto.getMessage());
    }

    @Test
    public void testSetterAndGetter() {
        // Arrange
        ErrorDto errorDto = new ErrorDto();
        String code = "ERROR_CODE";
        String message = "Error message";

        // Act
        errorDto.setCode(code);
        errorDto.setMessage(message);

        // Assert
        assertEquals(code, errorDto.getCode());
        assertEquals(message, errorDto.getMessage());
    }

    @Test
    public void testAllArgsConstructor() {
        // Arrange
        String code = "ERROR_CODE";
        String message = "Error message";

        // Act
        ErrorDto errorDto = new ErrorDto(code, message);

        // Assert
        assertEquals(code, errorDto.getCode());
        assertEquals(message, errorDto.getMessage());
    }

    @Test
    public void testEqualsMethod() {
        // Arrange
        String code = "ERROR_CODE";
        String message = "Error message";
        ErrorDto errorDto1 = new ErrorDto(code, message);
        ErrorDto errorDto2 = new ErrorDto(code, message);

        // Act and Assert
        assertEquals(errorDto1, errorDto2);
    }

}