package com.github.aruizrab.moviemicroservices.watchlist.domain;

import lombok.*;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class WatchListItem {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Getter
    @Setter
    @Column
    private long userId;
    @Getter
    @Setter
    @Column
    private long movieId;
}