package com.studiomediatech.example.varnished.web;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


/**
 * Chin up now, pay close attention. We are very quickly testing the unit to see if the end-points are properly mapped,
 * the controller delegation and the adapter behaviour - but look mom, NO MOCKS! Asserts here should only expect that
 * what the adapter returns by default - which is enough to ensure platform/framework integration with the
 * "inner-rings". None shall pass!
 */
class RootControllerTest {

    private MockMvc mockMvc;

    @BeforeEach
    void setup() {

        mockMvc = MockMvcBuilders.standaloneSetup(new RootController(Optional.empty())).build();
    }


    @Test
    void ensureRootControllerRendersIndexPage() throws Exception {

        mockMvc.perform(get("/"))
            .andExpect(status().isOk())
            .andExpect(model().attribute("name", "Lloyd"))
            .andExpect(view().name("index"));
    }
}
