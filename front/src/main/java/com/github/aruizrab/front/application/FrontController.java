package com.github.aruizrab.front.application;

import com.github.aruizrab.front.application.dto.UserCompositeDTO;
import com.github.aruizrab.front.domain.User;
import com.github.aruizrab.front.domain.UserComposite;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FrontController {

    @Autowired
    private UserService userService;

    @Autowired
    private WatchlistService watchlistService;

    @Autowired
    private MovieService movieService;

    @Autowired
    private ModelMapper modelMapper;



    public List<UserCompositeDTO> getUsers() {
        var users = userService.getUsers();
        var userComposites = users.stream().map(user -> modelMapper.map(user, UserComposite.class)).collect(Collectors.toList());
        userComposites.forEach(userComposite -> {
            var movieIds = watchlistService.getUserWatchlistMoviesIds(userComposite.getId());
            if (!movieIds.isEmpty()) {
                var movies = movieService.getMovies(movieIds);
                userComposite.setWatchlist(movies);
            } else {
                userComposite.setWatchlist(new ArrayList<>());
            }
        });
        return userComposites.stream().map(userComposite -> modelMapper.map(userComposite, UserCompositeDTO.class)).collect(Collectors.toList());
    }

    public UserCompositeDTO getUser(long id) {
        var user = userService.getUser(id);
        var movieIds = watchlistService.getUserWatchlistMoviesIds(user.getId());
        var userComposite = modelMapper.map(user, UserComposite.class);
        if (!movieIds.isEmpty()) {
            var movies = movieService.getMovies(movieIds);
            userComposite.setWatchlist(movies);
        } else {
            userComposite.setWatchlist(new ArrayList<>());
        }
        return modelMapper.map(userComposite, UserCompositeDTO.class);
    }

    public void addToUserWatchlist(long userId, long movieId) {
        var user = userService.getUser(userId);
        var movie = movieService.getMovie(movieId);
        watchlistService.addToUserWatchlist(userId, movieId);
    }

    public void createUser(UserCompositeDTO userCompositeDTO) {
        var user = modelMapper.map(userCompositeDTO, User.class);
        userService.createUser(user);
    }

    public void deleteUser(long id) {
        userService.deleteUser(id);
        watchlistService.deleteUser(id);
    }

    public void removeFromUserWatchlist(long userId, long movieId) {
        watchlistService.removeFromUserWatchlist(userId, movieId);
    }
}
