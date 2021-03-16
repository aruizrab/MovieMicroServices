package com.github.aruizrab.moviemicroservices.watchlist.api;

import com.github.aruizrab.moviemicroservices.watchlist.application.WatchListController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WatchListRestController {

    @Autowired
    private WatchListController watchListController;

    @GetMapping("/users/{id}/watch-list")
    public List<Long> getUserWatchlist(@PathVariable long id) {
        return watchListController.getUserWatchlist(id);
    }

    @PostMapping("/users/{userId}/watch-list/{movieId}")
    public void addToUserWatchlist(@PathVariable long userId, @PathVariable long movieId) {
        watchListController.addToUserWatchlist(userId, movieId);
    }
}
