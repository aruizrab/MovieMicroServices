package com.github.aruizrab.front.application;

import com.github.aruizrab.front.domain.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${app.movie-service.url}")
    private String userServiceUrl;

    public List<Movie> getMovies(List<Long> ids) {
        var url = userServiceUrl + "/movies/{ids}";
        var idsToString = ids.stream().map(id -> Long.toString(id)).collect(Collectors.joining(","));
        var response = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Movie>>() {
        }, idsToString);
        return response.getBody();
    }

    public Movie getMovie(long movieId) {
        return getMovies(Collections.singletonList(movieId)).get(0);
    }
}
