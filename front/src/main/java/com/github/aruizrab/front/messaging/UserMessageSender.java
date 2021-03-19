package com.github.aruizrab.front.messaging;

import com.github.aruizrab.front.api.configuration.UserChannel;
import com.github.aruizrab.front.domain.User;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;

@Service
@EnableBinding(UserChannel.class)
public class UserMessageSender {

    private final MessageChannel channel;

    public UserMessageSender(UserChannel userChannel) {
        this.channel = userChannel.senderUserChannel();
    }

    public void sendCreateUserMessage(User user) {
        var message = new Message<Long, User>(Message.Type.CREATE, user.getId(), user);
        channel.send(MessageBuilder.withPayload(message).build());
    }

    public void sendDeleteUserMessage(long id) {
        var message = new Message<Long, User>(Message.Type.DELETE, id, null);
        channel.send(MessageBuilder.withPayload(message).build());
    }
}
