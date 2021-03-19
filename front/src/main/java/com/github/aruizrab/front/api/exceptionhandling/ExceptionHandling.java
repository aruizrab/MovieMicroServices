package com.github.aruizrab.front.api.exceptionhandling;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

@ControllerAdvice
public class ExceptionHandling {

    @ExceptionHandler({HttpClientErrorException.class})
    ResponseEntity<String> onHttpClientErrorException(HttpClientErrorException e) {
        return new ResponseEntity<String>(e.getStatusText(), e.getStatusCode());
    }
}
