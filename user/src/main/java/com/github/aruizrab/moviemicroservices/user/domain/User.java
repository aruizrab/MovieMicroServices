package com.github.aruizrab.moviemicroservices.user.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Getter
    @Setter
    @Column(unique = true)
    private String name;
    @Getter
    @Setter
    @Column
    private String email;
}