package com.github.aruizrab.front.application;

import com.github.aruizrab.front.domain.User;
import com.github.aruizrab.front.messaging.UserMessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserMessageSender userMessageSender;

    @Value("${app.user-service.url}")
    private String userServiceUrl;

    public List<User> getUsers() {
        var url = userServiceUrl + "/users";
        var response = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<User>>() {
        });
        return response.getBody();
    }

    public User getUser(long id) {
        var url = userServiceUrl + "/users/{id}";
        var response = restTemplate.exchange(url, HttpMethod.GET, null, User.class, id);
        return response.getBody();
    }

    public void createUser(User user) {
        // var url = userServiceUrl + "/users";
        // restTemplate.exchange(url, HttpMethod.POST, new HttpEntity<>(user), String.class);
        userMessageSender.sendCreateUserMessage(user);
    }

    public void deleteUser(long id) {
        // var url = userServiceUrl + "/users/{id}";
        // restTemplate.exchange(url, HttpMethod.DELETE, null, String.class, id);
        userMessageSender.sendDeleteUserMessage(id);
    }
}
