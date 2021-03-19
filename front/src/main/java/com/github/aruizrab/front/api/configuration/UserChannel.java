package com.github.aruizrab.front.api.configuration;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface UserChannel {

    String USER_CHANNEL = "senderUserChannel";

    @Output(USER_CHANNEL)
    MessageChannel senderUserChannel();
}
