package com.psda.movies.moviesapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.psda.movies.moviesapi.models.MoviePicture;

public interface MoviePictureRepository extends JpaRepository<MoviePicture, Long> {

    // List all MoviePictures
    List<MoviePicture> findAll();

}
