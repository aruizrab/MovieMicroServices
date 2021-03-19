package com.github.aruizrab.watchlist.api.configuration;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface WatchlistChannel {

    String WATCHLIST_CHANNEL = "receiveWatchlistChannel";

    @Input(WATCHLIST_CHANNEL)
    SubscribableChannel receiveWatchlistChannel();
}
