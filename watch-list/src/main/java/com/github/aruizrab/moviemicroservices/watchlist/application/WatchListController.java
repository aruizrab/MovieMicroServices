package com.github.aruizrab.moviemicroservices.watchlist.application;

import com.github.aruizrab.moviemicroservices.watchlist.application.repository.IWatchListItemRepository;
import com.github.aruizrab.moviemicroservices.watchlist.domain.WatchListItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WatchListController {

    @Autowired
    private IWatchListItemRepository watchListItemRepository;

    public List<Long> getUserWatchlist(long id) {
        var items = watchListItemRepository.getWatchListItemsByUserId(id);
        return items.stream().map(WatchListItem::getMovieId).collect(Collectors.toList());
    }

    public void addToUserWatchlist(long userId, long movieId) {
        if (!getUserWatchlist(userId).contains(movieId)) {
            var item = WatchListItem.builder().userId(userId).movieId(movieId).build();
            watchListItemRepository.save(item);
        }
    }
}
