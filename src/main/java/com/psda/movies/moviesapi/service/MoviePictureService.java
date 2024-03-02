package com.psda.movies.moviesapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psda.movies.moviesapi.models.MoviePicture;
import com.psda.movies.moviesapi.repository.MoviePictureRepository;

@Service
public class MoviePictureService {

    @Autowired
    private MoviePictureRepository moviePictureRepository;

    // List all MoviePictures
    public List<MoviePicture> findAll() {
        return moviePictureRepository.findAll();
    }

}
