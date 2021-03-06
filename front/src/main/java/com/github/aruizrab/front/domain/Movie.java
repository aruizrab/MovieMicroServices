package com.github.aruizrab.front.domain;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    @Getter
    @Setter
    private long id;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private int year;
}
