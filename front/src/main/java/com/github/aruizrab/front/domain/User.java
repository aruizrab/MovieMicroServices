package com.github.aruizrab.front.domain;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Getter
    @Setter
    private long id;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String email;
}