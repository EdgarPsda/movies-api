package com.psda.movies.moviesapi.exceptions;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class InvalidVoteException extends RuntimeException {

    private String code;
    private HttpStatus status;

    public InvalidVoteException(String message, String code, HttpStatus status) {
        super(message);
        this.code = code;
        this.status = status;
    }

}
