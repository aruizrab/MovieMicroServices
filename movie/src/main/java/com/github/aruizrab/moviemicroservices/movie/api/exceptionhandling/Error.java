package com.github.aruizrab.moviemicroservices.movie.api.exceptionhandling;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class Error {
    @Getter @Setter
    private String title, message;
}
