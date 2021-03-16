package com.github.aruizrab.moviemicroservices.user.application;

import com.github.aruizrab.moviemicroservices.user.application.dto.UserDTO;
import com.github.aruizrab.moviemicroservices.user.application.exception.AlreadyExistsException;
import com.github.aruizrab.moviemicroservices.user.application.exception.NotFoundException;
import com.github.aruizrab.moviemicroservices.user.application.repository.IUserRepository;
import com.github.aruizrab.moviemicroservices.user.domain.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserController {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    public UserDTO createUser(UserDTO userDTO) {
        if (userRepository.findUserByName(userDTO.getName()).isPresent()) {
            throw new AlreadyExistsException("User with NAME=" + userDTO.getName() + " already exists.");
        }
        var user = modelMapper.map(userDTO, User.class);
        user = userRepository.save(user);
        return modelMapper.map(user, UserDTO.class);
    }

    public List<UserDTO> getUsers() {
        var users = userRepository.findAll();
        return users
                .stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList());
    }

    public UserDTO getUser(long id) {
        var user = userRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("User with ID=" + id + " does not exist."));
        return modelMapper.map(user, UserDTO.class);
    }

    public UserDTO deleteUser(long id) {
        var user = userRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("User with ID=" + id + " does not exist."));
        userRepository.delete(user);
        return modelMapper.map(user, UserDTO.class);
    }
}
