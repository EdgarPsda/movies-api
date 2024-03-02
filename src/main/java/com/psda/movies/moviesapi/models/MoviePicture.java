package com.psda.movies.moviesapi.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "movie_pictures")
public class MoviePicture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "url")
    @NotBlank(message = "URL is required")
    private String url;

    @Column(name = "favorites_count")
    @NotNull(message = "Description is required")
    private Integer favoritesCount;

    @Column(name = "movie_id")
    @NotNull(message = "Movie ID is required")
    private Long movieId;

    @Column(name = "release_year")
    @NotNull(message = "Release year is required")
    private Integer releaseYear;

}
