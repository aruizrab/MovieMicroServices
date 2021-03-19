package com.github.aruizrab.movie.application.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
public class MovieDTO {
    @Getter
    @Setter
    private long id;
    @Getter
    @Setter
    @NotNull(message = "Can't be null")
    @NotBlank(message = "Can't be blank")
    private String name;
    @Getter
    @Setter
    @NotNull(message = "Can't be null")
    @Min(value = 1888, message = "Movies didn't exist before 1888 you dumbass.")
    private int year;
}
