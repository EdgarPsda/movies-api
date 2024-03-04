package com.psda.movies.moviesapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.psda.movies.moviesapi.models.MoviePicture;

public interface MoviePictureRepository extends JpaRepository<MoviePicture, Long> {

    // List all MoviePictures
    List<MoviePicture> findAll();

    // List all movie pictures of a particular release year
    List<MoviePicture> findAllByReleaseYear(Integer releaseYear);

    // List all movie pictures grouped by release year
    @Query("SELECT mp FROM MoviePicture mp ORDER BY mp.releaseYear DESC, mp.favoritesCount DESC")
    List<MoviePicture> findAllOrderByReleaseYearDescAndFavoritesCountDesc();

    // Vote up a movie picture
    MoviePicture save(MoviePicture moviePicture);

}
