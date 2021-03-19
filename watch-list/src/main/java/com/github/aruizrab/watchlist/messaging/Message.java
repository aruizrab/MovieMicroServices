package com.github.aruizrab.watchlist.messaging;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Message<K, V> {

    @Getter
    private Type type;
    @Getter
    private K key;
    @Getter
    private V value;

    public enum Type {CREATE, DELETE, ADD, REMOVE}
}
