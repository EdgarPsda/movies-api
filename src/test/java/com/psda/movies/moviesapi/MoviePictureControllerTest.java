package com.psda.movies.moviesapi;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.psda.movies.moviesapi.controllers.MoviePictureController;
import com.psda.movies.moviesapi.models.MoviePicture;
import com.psda.movies.moviesapi.service.MoviePictureService;
import static org.junit.jupiter.api.Assertions.assertEquals; // Import the necessary assertion class

@RunWith(MockitoJUnitRunner.class)
public class MoviePictureControllerTest {

    @InjectMocks
    private MoviePictureController moviePictureController;

    @Mock
    private MoviePictureService moviePictureService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAll() {
        // Arrange
        List<MoviePicture> moviePictures = new ArrayList<>();
        moviePictures.add(new MoviePicture());
        moviePictures.add(new MoviePicture());
        when(moviePictureService.findAll()).thenReturn(moviePictures);

        // Act
        ResponseEntity<List<MoviePicture>> response = moviePictureController.findAll();

        // Assert
        assertEquals(moviePictures, response.getBody()); // Modify the assertion statement
    }

    @Test
    public void testFindAllByReleaseYear() {
        // Arrange
        Integer releaseYear = 2022;
        List<MoviePicture> moviePictures = new ArrayList<>();
        moviePictures.add(new MoviePicture());
        moviePictures.add(new MoviePicture());
        when(moviePictureService.findAllByReleaseYear(releaseYear)).thenReturn(moviePictures);

        // Act
        ResponseEntity<List<MoviePicture>> response = moviePictureController.findAllByReleaseYear(releaseYear);

        // Assert
        assertEquals(moviePictures, response.getBody());
    }

    @SuppressWarnings({ "deprecation", "null" })
    @Test
    public void testFindAllGroupedByReleaseYear() {
        // Arrange
        MoviePicture moviePicture1 = new MoviePicture();
        moviePicture1.setReleaseYear(2020);
        MoviePicture moviePicture2 = new MoviePicture();
        moviePicture2.setReleaseYear(2021);
        List<MoviePicture> moviePictures2020 = Arrays.asList(moviePicture1);
        List<MoviePicture> moviePictures2021 = Arrays.asList(moviePicture2);
        Map<Integer, List<MoviePicture>> moviePicturesGroupedByYear = new HashMap<>();
        moviePicturesGroupedByYear.put(2020, moviePictures2020);
        moviePicturesGroupedByYear.put(2021, moviePictures2021);
        when(moviePictureService.findAllGroupedByReleaseYear()).thenReturn(moviePicturesGroupedByYear);

        // Act
        @SuppressWarnings("unchecked")
        ResponseEntity<Map<Integer, List<MoviePicture>>> response = (ResponseEntity<Map<Integer, List<MoviePicture>>>) moviePictureController
                .findAllGroupedByReleaseYear();

        // Assert
        assertEquals(response.getStatusCodeValue(), 200);
        assertEquals(response.getBody().size(), 2);
    }

    // Test voteUp
    @SuppressWarnings({ "deprecation", "null" })
    @Test
    public void testVoteUp() {
        // Arrange
        Long id = 1L;
        String vote = "up";
        MoviePicture moviePicture = new MoviePicture();
        moviePicture.setId(id);
        moviePicture.setFavoritesCount(10);
        when(moviePictureService.voteUp(id, vote)).thenReturn(moviePicture);

        // Act
        ResponseEntity<?> response = moviePictureController.voteUp(id, vote);

        // Assert
        assertEquals(response.getStatusCodeValue(), 200);
        assertEquals(((MoviePicture) response.getBody()).getId(), id);
        assertEquals(((MoviePicture) response.getBody()).getFavoritesCount(), 10);
    }
}