package com.github.aruizrab.moviemicroservices.user.api;

import com.github.aruizrab.moviemicroservices.user.application.UserController;
import com.github.aruizrab.moviemicroservices.user.application.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserRestController {

    @Autowired
    private UserController userController;

    @PostMapping("/users")
    public UserDTO postUser(@Validated @RequestBody UserDTO userDTO) {
        return userController.createUser(userDTO);
    }

    @GetMapping("/users")
    public List<UserDTO> getUsers() {
        return userController.getUsers();
    }

    @GetMapping("/users/{id}")
    public UserDTO getUsers(@PathVariable long id) {
        return userController.getUser(id);
    }

    @DeleteMapping("/users/{id}")
    public UserDTO deleteUser(@PathVariable long id) {
        return userController.deleteUser(id);
    }
}
