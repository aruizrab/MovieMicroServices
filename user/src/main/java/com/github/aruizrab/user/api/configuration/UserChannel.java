package com.github.aruizrab.user.api.configuration;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface UserChannel {

    String USER_CHANNEL = "receiverUserChannel";

    @Input(USER_CHANNEL)
    SubscribableChannel receiverUserChannel();
}
