package com.studiomediatech.example.varnished.app;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class VarnishedApplicationTests {

    @Test
    @DisplayName("the application context starts without failures")
    void contextLoads() {

        assertThat(true).isTrue();
    }
}
