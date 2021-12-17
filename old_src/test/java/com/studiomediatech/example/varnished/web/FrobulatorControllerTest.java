package com.studiomediatech.example.varnished.web;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


class FrobulatorControllerTest {

    private MockMvc mockMvc;

    @BeforeEach
    void setup() {

        mockMvc = MockMvcBuilders.standaloneSetup(new FrobulatorController(Optional.empty())).build();
    }


    @Test
    void ensureAdapts() throws Exception {

        mockMvc.perform(get("/frobulators/some-frobulator-key"))
            .andExpect(status().isOk())
            .andExpect(view().name("frobulators/details"));
    }
}
