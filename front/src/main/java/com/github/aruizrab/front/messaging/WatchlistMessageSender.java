package com.github.aruizrab.front.messaging;

import com.github.aruizrab.front.api.configuration.WatchlistChannel;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;

@Service
@EnableBinding(WatchlistChannel.class)
public class WatchlistMessageSender {

    private final MessageChannel channel;

    public WatchlistMessageSender(WatchlistChannel watchlistChannel) {
        channel = watchlistChannel.senderWatchlistChannel();
    }

    public void sendAddToUserWatchlistMessage(long userId, long movieId) {
        var message = new Message<Long, Long>(Message.Type.ADD, userId, movieId);
        channel.send(MessageBuilder.withPayload(message).build());
    }

    public void sendRemoveFromUserWatchlistMessage(long userId, long movieId) {
        var message = new Message<Long, Long>(Message.Type.REMOVE, userId, movieId);
        channel.send(MessageBuilder.withPayload(message).build());
    }

    public void sendDeleteUserMessage(long userId) {
        var message = new Message<Long, Null>(Message.Type.DELETE, userId, null);
        channel.send(MessageBuilder.withPayload(message).build());
    }
}
