package com.github.aruizrab.front.api;

import com.github.aruizrab.front.application.FrontController;
import com.github.aruizrab.front.application.dto.UserCompositeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FrontRestController {

    @Autowired
    private FrontController frontController;

    @GetMapping("/users")
    public List<UserCompositeDTO> getUsers() {
        return frontController.getUsers();
    }

    @PostMapping("/users")
    public void postUser(@RequestBody UserCompositeDTO userCompositeDTO) {
        frontController.createUser(userCompositeDTO);
    }

    @GetMapping("/users/{id}")
    public UserCompositeDTO getUser(@PathVariable long id) {
        return frontController.getUser(id);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable long id) {
        frontController.deleteUser(id);
    }

    @PostMapping("/users/{userId}/watch-list/{movieId}")
    public void addToUserWatchlist(@PathVariable long userId, @PathVariable long movieId) {
        frontController.addToUserWatchlist(userId, movieId);
    }

    @DeleteMapping("/users/{userId}/watch-list/{movieId}")
    public void removeFromUserWatchlist(@PathVariable long userId, @PathVariable long movieId) {
        frontController.removeFromUserWatchlist(userId, movieId);
    }
}
