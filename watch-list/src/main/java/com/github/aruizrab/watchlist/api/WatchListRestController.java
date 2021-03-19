package com.github.aruizrab.watchlist.api;

import com.github.aruizrab.watchlist.application.WatchListController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class WatchListRestController {

    @Autowired
    private WatchListController watchListController;

    @GetMapping("/{userId}/watch-list")
    public List<Long> getUserWatchlist(@PathVariable long userId) {
        return watchListController.getUserWatchlist(userId);
    }

    @PostMapping("/{userId}/watch-list/{movieId}")
    public void addToUserWatchlist(@PathVariable long userId, @PathVariable long movieId) {
        watchListController.addToUserWatchlist(userId, movieId);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable long userId) {
        watchListController.deleteUser(userId);
    }

    @DeleteMapping("/{userId}/watch-list/{movieId}")
    public void deleteMovieFromUserWatchList(@PathVariable long userId, @PathVariable long movieId) {
        watchListController.deleteMovieFromUserWatchList(userId, movieId);
    }
}