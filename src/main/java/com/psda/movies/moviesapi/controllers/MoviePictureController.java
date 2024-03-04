package com.psda.movies.moviesapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.psda.movies.moviesapi.models.MoviePicture;
import com.psda.movies.moviesapi.service.MoviePictureService;

@RestController
@RequestMapping("/api/v1")
public class MoviePictureController {

    @Autowired
    private MoviePictureService moviePictureService;

    // List all MoviePictures
    @GetMapping("/movie-pictures")
    public ResponseEntity<List<MoviePicture>> findAll() {
        return ResponseEntity.ok(moviePictureService.findAll());
    }

    // List all movie pictures of a particular release year
    @GetMapping("/movie-pictures/release-year/{releaseYear}")
    public ResponseEntity<List<MoviePicture>> findAllByReleaseYear(@PathVariable Integer releaseYear) {
        return ResponseEntity.ok(moviePictureService.findAllByReleaseYear(releaseYear));
    }

    // List all movie pictures grouped by release year
    @GetMapping("/movie-pictures/grouped-by-release-year")
    public ResponseEntity<?> findAllGroupedByReleaseYear() {
        return ResponseEntity.ok(moviePictureService.findAllGroupedByReleaseYear());
    }

    // Vote up a movie picture
    @GetMapping("/movie-pictures/vote-up/{id}/{vote}")
    public ResponseEntity<?> voteUp(@PathVariable Long id, @PathVariable String vote) {
        return ResponseEntity.ok(moviePictureService.voteUp(id, vote));
    }

}
