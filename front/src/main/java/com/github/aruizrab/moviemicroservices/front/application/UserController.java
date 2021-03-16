package com.github.aruizrab.moviemicroservices.front.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserController {

    @Autowired
    private RestTemplate restTemplate;


}
