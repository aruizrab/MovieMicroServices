package com.github.aruizrab.user.api.exceptionhandling;

import com.github.aruizrab.user.application.exception.AlreadyExistsException;
import com.github.aruizrab.user.application.exception.NotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionHandling {

    @ResponseBody
    @ExceptionHandler({AlreadyExistsException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    Error onDataIntegrityViolationException(AlreadyExistsException e) {
        return new Error("Already exists", e.getMessage());
    }

    @ExceptionHandler({NotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    Error onNotFoundException(NotFoundException e) {
        return new Error("Not found", e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    List<Error> onMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return e.getBindingResult().getFieldErrors()
                .stream()
                .map(fieldError -> new Error("Wrong parameter", fieldError.getField() + ": " + fieldError.getDefaultMessage()))
                .collect(Collectors.toList());
    }
}
