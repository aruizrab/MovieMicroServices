package com.github.aruizrab.moviemicroservices.front.api;

import com.github.aruizrab.moviemicroservices.front.application.dto.UserCompositeDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FrontRestController {

    @GetMapping("/users")
    public void getUsers() {

    }
}
