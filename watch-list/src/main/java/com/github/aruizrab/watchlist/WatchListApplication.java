package com.github.aruizrab.watchlist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class WatchListApplication {

    public static void main(String[] args) {
        SpringApplication.run(WatchListApplication.class, args);
    }

}
