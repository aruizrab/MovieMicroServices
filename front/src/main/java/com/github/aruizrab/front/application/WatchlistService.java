package com.github.aruizrab.front.application;

import com.github.aruizrab.front.messaging.WatchlistMessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class WatchlistService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WatchlistMessageSender watchlistMessageSender;

    @Value("${app.watchlist-service.url}")
    private String userServiceUrl;

    public List<Long> getUserWatchlistMoviesIds(long id) {
        var url = userServiceUrl + "/users/{id}/watch-list";
        var response = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Long>>() {
        }, id);
        return response.getBody();
    }

    public void addToUserWatchlist(long userId, long movieId) {
        // var url = userServiceUrl + "/users/{userId}/watch-list/{movieId}";
        // restTemplate.exchange(url, HttpMethod.POST, null, String.class, userId, movieId);
        watchlistMessageSender.sendAddToUserWatchlistMessage(userId, movieId);
    }

    public void deleteUser(long id) {
        // var url = userServiceUrl + "/users/{id}";
        // restTemplate.exchange(url, HttpMethod.DELETE, null, String.class, id);
        watchlistMessageSender.sendDeleteUserMessage(id);
    }

    public void removeFromUserWatchlist(long userId, long movieId) {
        // var url = userServiceUrl + "/users/{userId}/watch-list/{movieId}";
        // restTemplate.exchange(url, HttpMethod.DELETE, null, String.class, userId, movieId);
        watchlistMessageSender.sendRemoveFromUserWatchlistMessage(userId, movieId);
    }
}
