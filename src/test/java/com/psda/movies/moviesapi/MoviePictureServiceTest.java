package com.psda.movies.moviesapi;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import com.psda.movies.moviesapi.exceptions.InvalidVoteException;
import com.psda.movies.moviesapi.exceptions.ResourceNotFoundException;
import com.psda.movies.moviesapi.models.MoviePicture;
import com.psda.movies.moviesapi.repository.MoviePictureRepository;
import com.psda.movies.moviesapi.service.MoviePictureService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;

import java.util.Optional;

public class MoviePictureServiceTest {

    @Mock
    private MoviePictureRepository moviePictureRepository;

    @InjectMocks
    private MoviePictureService moviePictureService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testVoteUpWithValidIdAndVoteUp() {
        // Arrange
        Long id = 1L;
        String vote = "up";
        MoviePicture moviePicture = new MoviePicture();
        moviePicture.setId(id);
        moviePicture.setFavoritesCount(10);

        when(moviePictureRepository.findById(id)).thenReturn(Optional.of(moviePicture));
        when(moviePictureRepository.save(moviePicture)).thenReturn(moviePicture);

        // Act
        MoviePicture result = moviePictureService.voteUp(id, vote);

        // Assert
        assertEquals(11, result.getFavoritesCount());
        verify(moviePictureRepository, times(1)).findById(id);
        verify(moviePictureRepository, times(1)).save(moviePicture);
    }

    @Test
    public void testVoteUpWithValidIdAndVoteDown() {
        // Arrange
        Long id = 1L;
        String vote = "down";
        MoviePicture moviePicture = new MoviePicture();
        moviePicture.setId(id);
        moviePicture.setFavoritesCount(10);

        when(moviePictureRepository.findById(id)).thenReturn(Optional.of(moviePicture));
        when(moviePictureRepository.save(moviePicture)).thenReturn(moviePicture);

        // Act
        MoviePicture result = moviePictureService.voteUp(id, vote);

        // Assert
        assertEquals(9, result.getFavoritesCount());
        verify(moviePictureRepository, times(1)).findById(id);
        verify(moviePictureRepository, times(1)).save(moviePicture);
    }

    @Test
    public void testVoteUpWithInvalidId() {
        // Arrange
        Long id = 1L;
        String vote = "up";

        when(moviePictureRepository.findById(id)).thenReturn(Optional.empty());

        // Act and Assert
        assertThrows(ResourceNotFoundException.class, () -> {
            moviePictureService.voteUp(id, vote);
        }, "Expected ResourceNotFoundException to be thrown");
        verify(moviePictureRepository, times(1)).findById(id);
        verify(moviePictureRepository, never()).save(any());
    }

    @Test
    public void testVoteUpWithInvalidVote() {
        // Arrange
        Long id = 1L;
        String vote = "invalid";
        MoviePicture moviePicture = new MoviePicture();
        moviePicture.setId(id);

        when(moviePictureRepository.findById(id)).thenReturn(Optional.of(moviePicture));

        // Act and Assert
        assertThrows(InvalidVoteException.class, () -> {
            moviePictureService.voteUp(id, vote);
        }, "Expected InvalidVoteException to be thrown");
        verify(moviePictureRepository, times(1)).findById(id);
        verify(moviePictureRepository, never()).save(any());
    }
}