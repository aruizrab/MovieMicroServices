package com.github.aruizrab.user.api;

import com.github.aruizrab.user.application.UserController;
import com.github.aruizrab.user.application.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserRestController {

    @Autowired
    private UserController userController;

    @PostMapping
    public UserDTO postUser(@Validated @RequestBody UserDTO userDTO) {
        return userController.createUser(userDTO);
    }

    @GetMapping
    public List<UserDTO> getUsers() {
        return userController.getUsers();
    }

    @GetMapping("/{id}")
    public UserDTO getUsers(@PathVariable long id) {
        return userController.getUser(id);
    }

    @DeleteMapping("/{id}")
    public UserDTO deleteUser(@PathVariable long id) {
        return userController.deleteUser(id);
    }
}
