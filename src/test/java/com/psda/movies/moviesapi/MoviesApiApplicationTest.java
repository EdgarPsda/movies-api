package com.psda.movies.moviesapi;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MoviesApiApplicationTest {

    @Test
    public void contextLoads() {
        // Assert
        assertTrue(true);
    }

    @Test
    public void testMain() {
        // Arrange
        String[] args = {};

        // Act and Assert
        assertDoesNotThrow(() -> {
            MoviesApiApplication.main(args);
        });
    }
}