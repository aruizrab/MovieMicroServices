package com.github.aruizrab.movie.application;

import com.github.aruizrab.movie.application.dto.MovieDTO;
import com.github.aruizrab.movie.application.exception.NotFoundException;
import com.github.aruizrab.movie.application.repository.IMovieRepository;
import com.github.aruizrab.movie.domain.Movie;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieController {

    @Autowired
    private IMovieRepository movieRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<MovieDTO> getMovies() {
        var movies = movieRepository.findAll();
        return movies.stream().map(movie -> modelMapper.map(movie, MovieDTO.class)).collect(Collectors.toList());
    }

    public MovieDTO createMovie(MovieDTO movieDTO) {
        var movie = modelMapper.map(movieDTO, Movie.class);
        movie = movieRepository.save(movie);
        return modelMapper.map(movie, MovieDTO.class);
    }

    public MovieDTO getMovie(long id) {
        var movie = movieRepository.findById(id).orElseThrow(() -> new NotFoundException("Movie with ID=" + id + " does not exist."));
        return modelMapper.map(movie, MovieDTO.class);
    }

    public MovieDTO deleteMovie(long id) {
        var movie = movieRepository.findById(id).orElseThrow(() -> new NotFoundException("Movie with ID=" + id + " does not exist."));
        movieRepository.delete(movie);
        return modelMapper.map(movie, MovieDTO.class);
    }

    public List<MovieDTO> getMovies(List<Long> ids) {
        var movies = new ArrayList<MovieDTO>();
        ids.forEach(id -> movies.add(getMovie(id)));
        return movies;
    }
}
