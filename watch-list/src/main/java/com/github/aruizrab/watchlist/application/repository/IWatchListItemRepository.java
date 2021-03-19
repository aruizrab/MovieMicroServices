package com.github.aruizrab.watchlist.application.repository;

import com.github.aruizrab.watchlist.domain.WatchListItem;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface IWatchListItemRepository extends JpaRepository<WatchListItem, Long> {
    List<WatchListItem> getWatchListItemsByUserId(long userId);

    @Transactional
    void deleteWatchListItemsByUserId(long userId);

    @Transactional
    void deleteWatchListItemByUserIdAndMovieId(long userId, long movieId);
}
