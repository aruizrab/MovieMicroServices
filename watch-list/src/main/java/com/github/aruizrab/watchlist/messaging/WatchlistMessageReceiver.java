package com.github.aruizrab.watchlist.messaging;

import com.github.aruizrab.watchlist.api.configuration.WatchlistChannel;
import com.github.aruizrab.watchlist.application.WatchListController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

@Service
@EnableBinding(WatchlistChannel.class)
public class WatchlistMessageReceiver {

    @Autowired
    private WatchListController watchListController;

    @StreamListener(WatchlistChannel.WATCHLIST_CHANNEL)
    public void receiveMessage(Message<Long, Long> message) {
        switch (message.getType()) {
            case ADD:
                watchListController.addToUserWatchlist(message.getKey(), message.getValue());
                break;
            case REMOVE:
                watchListController.deleteMovieFromUserWatchList(message.getKey(), message.getValue());
                break;
            case DELETE:
                watchListController.deleteUser(message.getKey());
                break;
        }
    }
}
