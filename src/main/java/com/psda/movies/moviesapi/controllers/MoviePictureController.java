package com.psda.movies.moviesapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
        System.out.println("Hello");
        return ResponseEntity.ok(moviePictureService.findAll());
    }

}
