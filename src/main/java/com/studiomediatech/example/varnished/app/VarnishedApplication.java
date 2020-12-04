package com.studiomediatech.example.varnished.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Configuration;


/**
 * This is just a starter-class - as it should be. It's not at all enterprisey to fill it with configurations or bean
 * wiring - that stuff belong in {@link Configuration} files. Don't be that guy. Clean app-starter classes, are for
 * winners!
 */
@SpringBootApplication
public class VarnishedApplication {

    public static void main(String[] args) {

        SpringApplication.run(VarnishedApplication.class, args);
    }
}
