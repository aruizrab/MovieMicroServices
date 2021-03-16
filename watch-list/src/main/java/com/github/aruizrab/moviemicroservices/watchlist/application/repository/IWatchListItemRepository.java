package com.github.aruizrab.moviemicroservices.watchlist.application.repository;

import com.github.aruizrab.moviemicroservices.watchlist.domain.WatchListItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IWatchListItemRepository extends JpaRepository<WatchListItem, Long> {
    List<WatchListItem> getWatchListItemsByUserId(long userId);
}
