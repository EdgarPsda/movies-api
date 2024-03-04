package com.psda.movies.moviesapi.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorDto {
    private String code;
    private String message;

    // empty constructor
    public ErrorDto() {
    }

    // constructor with parameters
    public ErrorDto(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
