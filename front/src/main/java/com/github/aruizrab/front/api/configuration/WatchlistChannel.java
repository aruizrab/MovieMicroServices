package com.github.aruizrab.front.api.configuration;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface WatchlistChannel {

    String WATCHLIST_CHANNEL = "senderWatchlistChannel";

    @Output(WATCHLIST_CHANNEL)
    MessageChannel senderWatchlistChannel();
}
