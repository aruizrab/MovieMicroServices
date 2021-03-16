package com.github.aruizrab.moviemicroservices.user.application.repository;

import com.github.aruizrab.moviemicroservices.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByName(String name);
}
