package com.github.aruizrab.moviemicroservices.front.application.dto;

import com.github.aruizrab.moviemicroservices.front.domain.Movie;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
public class UserCompositeDTO {
    @Getter
    @Setter
    private long id;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String email;
    @Getter
    @Setter
    private List<Movie> watchlist;
}
