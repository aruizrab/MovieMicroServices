package com.github.aruizrab.moviemicroservices.movie.application.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
