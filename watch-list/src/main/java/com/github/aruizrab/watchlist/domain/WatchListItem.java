package com.github.aruizrab.watchlist.domain;

import lombok.*;

import javax.persistence.*;
import javax.transaction.Transactional;

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