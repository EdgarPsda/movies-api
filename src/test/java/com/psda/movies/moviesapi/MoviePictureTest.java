package com.psda.movies.moviesapi;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.HashSet;
import java.util.Set;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.psda.movies.moviesapi.models.MoviePicture;

public class MoviePictureTest {

    @BeforeAll
    public static void setup() {

    }

    @Test
    public void testValidation() {
        // Arrange
        MoviePicture moviePicture = new MoviePicture();

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        // Act and Assert
        assertThrows(ConstraintViolationException.class, () -> {
            Set<ConstraintViolation<MoviePicture>> violations = validator.validate(moviePicture);
            if (!violations.isEmpty()) {
                throw new ConstraintViolationException(new HashSet<ConstraintViolation<?>>(violations));
            }
        });
    }

    @Test
    public void testMoviePictureId() {
        // Arrange
        MoviePicture moviePicture = new MoviePicture();
        moviePicture.setId(1L); // Set the ID to a non-null value

        // Act and Assert
        assertNotNull(moviePicture.getId());
    }

    // test other fields
    @Test
    public void testMoviePictureUrl() {
        // Arrange
        MoviePicture moviePicture = new MoviePicture();
        moviePicture.setUrl("https://www.example.com/image.jpg"); // Set the URL to a non-null value

        // Act and Assert
        assertNotNull(moviePicture.getUrl());
    }

    @Test
    public void testMoviePictureFavoritesCount() {
        // Arrange
        MoviePicture moviePicture = new MoviePicture();
        moviePicture.setFavoritesCount(10); // Set the favorites count to a non-null value

        // Act and Assert
        assertNotNull(moviePicture.getFavoritesCount());
    }

    @Test
    public void testMoviePictureMovieId() {
        // Arrange
        MoviePicture moviePicture = new MoviePicture();
        moviePicture.setMovieId(1L); // Set the movie ID to a non-null value

        // Act and Assert
        assertNotNull(moviePicture.getMovieId());
    }

    @Test
    public void testMoviePictureReleaseYear() {
        // Arrange
        MoviePicture moviePicture = new MoviePicture();
        moviePicture.setReleaseYear(2022); // Set the release year to a non-null value

        // Act and Assert
        assertNotNull(moviePicture.getReleaseYear());
    }

    // test equals and hashcode
    @Test
    public void testEquals() {
        // Arrange
        MoviePicture moviePicture1 = new MoviePicture();
        moviePicture1.setId(1L);
        MoviePicture moviePicture2 = new MoviePicture();
        moviePicture2.setId(1L);

        // Act and Assert
        assertTrue(moviePicture1.equals(moviePicture2));
        assertFalse(moviePicture1.equals(null));
        assertFalse(moviePicture1.equals(new Object()));
        // Test with different IDs
        moviePicture2.setId(2L);
        assertFalse(moviePicture1.equals(moviePicture2));

        // Test with different classes
        assertFalse(moviePicture1.equals("string"));
        // Test with the same object
        assertTrue(moviePicture1.equals(moviePicture1));
        // Test with different objects
        assertFalse(moviePicture1.equals(new MoviePicture()));

    }

    @Test
    public void testHashCode() {
        // Arrange
        MoviePicture moviePicture1 = new MoviePicture();
        moviePicture1.setId(1L);
        MoviePicture moviePicture2 = new MoviePicture();
        moviePicture2.setId(1L);

        // Act and Assert
        assertEquals(moviePicture1.hashCode(), moviePicture2.hashCode());
    }

    // test toString
    @Test
    public void testToString() {
        // Arrange
        MoviePicture moviePicture = new MoviePicture();
        moviePicture.setId(1L);
        moviePicture.setUrl("https://www.example.com/image.jpg");
        moviePicture.setFavoritesCount(10);
        moviePicture.setMovieId(1L);
        moviePicture.setReleaseYear(2022);

        // Act and Assert
        assertEquals(
                "MoviePicture(id=1, url=https://www.example.com/image.jpg, favoritesCount=10, movieId=1, releaseYear=2022)",
                moviePicture.toString());
    }

}