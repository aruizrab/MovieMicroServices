package com.github.aruizrab.movie.application.repository;

import com.github.aruizrab.movie.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Year;
import java.util.List;

public interface IMovieRepository extends JpaRepository<Movie, Long> {
    Movie getMovieByName(String name);
    List<Movie> getMoviesByYear(Year year);
}
