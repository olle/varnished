package com.studiomediatech.example.varnished.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Configuration;

import org.springframework.core.env.Profiles;


/**
 * This is just a starter-class - as it should be. It's not at all enterprisey to fill it with configurations or bean
 * wiring - that stuff belong in {@link Configuration} files. Don't be that guy. Clean app-starter classes, are for
 * winners!
 */
@SpringBootApplication
public class VarnishedApplication {

    /**
     * It's a good idea to declare this constant - for use in configurations.
     */
    public static final Profiles DEVELOPMENT = Profiles.of("localhost");

    public static void main(String[] args) {

        SpringApplication.run(VarnishedApplication.class, args);
    }
}
