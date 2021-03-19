package com.github.aruizrab.front.domain;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserComposite {
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

    public void addToWatchlist(Movie movie) {
        if (watchlist == null) {
            watchlist = new ArrayList<>();
        }
        if (watchlist.stream().noneMatch(m -> m.getId() == movie.getId())) {
            watchlist.add(movie);
        }
    }
}
