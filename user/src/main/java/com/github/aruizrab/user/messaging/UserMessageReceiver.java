package com.github.aruizrab.user.messaging;

import com.github.aruizrab.user.api.configuration.UserChannel;
import com.github.aruizrab.user.application.UserController;
import com.github.aruizrab.user.application.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

@Service
@EnableBinding(UserChannel.class)
public class UserMessageReceiver {

    @Autowired
    private UserController userController;

    @StreamListener(UserChannel.USER_CHANNEL)
    public void receiveMessage(Message<Long, UserDTO> message) {
        switch (message.getType()) {
            case CREATE:
                userController.createUser(message.getValue());
                break;
            case DELETE:
                userController.deleteUser(message.getKey());
                break;
        }
    }
}
