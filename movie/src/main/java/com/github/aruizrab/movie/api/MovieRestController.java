package com.github.aruizrab.movie.api;

import com.github.aruizrab.movie.application.MovieController;
import com.github.aruizrab.movie.application.dto.MovieDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieRestController {

    @Autowired
    private MovieController movieController;

    @GetMapping
    public List<MovieDTO> getMovies() {
        return movieController.getMovies();
    }

    /**
    @GetMapping("/{id}")
    public MovieDTO getMovie(@PathVariable long id) {
        return movieController.getMovie(id);
    }
     */

    @GetMapping("/{ids}")
    public List<MovieDTO> getMovies(@PathVariable List<Long> ids) {
        return movieController.getMovies(ids);
    }

    @PostMapping
    public MovieDTO postMovie(@RequestBody @Validated MovieDTO movieDTO) {
        return movieController.createMovie(movieDTO);
    }

    @DeleteMapping("/{id}")
    public MovieDTO deleteMovie(@PathVariable long id) {
        return movieController.deleteMovie(id);
    }
}
