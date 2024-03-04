package com.psda.movies.moviesapi.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.psda.movies.moviesapi.exceptions.InvalidVoteException;
import com.psda.movies.moviesapi.exceptions.ResourceNotFoundException;
import com.psda.movies.moviesapi.models.MoviePicture;
import com.psda.movies.moviesapi.repository.MoviePictureRepository;

@Service
public class MoviePictureService {

    @Autowired
    private MoviePictureRepository moviePictureRepository;

    // List all MoviePictures
    public List<MoviePicture> findAll() {
        List<MoviePicture> result = moviePictureRepository.findAll();
        if (result.isEmpty()) {
            throw new ResourceNotFoundException("No movie pictures found", "404", HttpStatus.NOT_FOUND);
        }
        return result;
    }

    // List all movie pictures of a particular release year
    public List<MoviePicture> findAllByReleaseYear(Integer releaseYear) {
        return moviePictureRepository.findAllByReleaseYear(releaseYear);
    }

    // List all movie pictures grouped by release year
    public Map<Integer, List<MoviePicture>> findAllGroupedByReleaseYear() {
        List<MoviePicture> moviePictures = moviePictureRepository.findAllOrderByReleaseYearDescAndFavoritesCountDesc();
        return moviePictures.stream().collect(Collectors.groupingBy(MoviePicture::getReleaseYear));
    }

    // Vote up a movie picture
    public MoviePicture voteUp(Long id, String vote) {
        MoviePicture moviePicture = moviePictureRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Movie Picture not found with ID: " + id, "404",
                        HttpStatus.NOT_FOUND));
        switch (vote) {
            case "up":
                moviePicture.setFavoritesCount(moviePicture.getFavoritesCount() + 1);
                break;
            case "down":
                moviePicture.setFavoritesCount(moviePicture.getFavoritesCount() - 1);
                break;
            default:
                throw new InvalidVoteException("Invalid vote: " + vote, "400", HttpStatus.BAD_REQUEST);
        }

        return moviePictureRepository.save(moviePicture);
    }

}
