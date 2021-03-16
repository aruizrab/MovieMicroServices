package com.github.aruizrab.moviemicroservices.movie.domain;

import lombok.*;

import javax.persistence.*;
import java.time.Year;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Getter
    @Setter
    @Column
    private String name;
    @Getter
    @Setter
    @Column
    private int year;
}
