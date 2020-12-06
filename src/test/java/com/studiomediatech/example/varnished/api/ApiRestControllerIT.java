package com.studiomediatech.example.varnished.api;

import com.studiomediatech.example.varnished.api.config.ApiConfig;
import com.studiomediatech.example.varnished.api.frobulator.FrobulatorApiAccess;
import com.studiomediatech.example.varnished.app.config.SecurityConfig;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * This, right here, is the start of the road to hell. There's currently not that much one can do about it, since we
 * absolutely want to test with a properly running application context, and MVC and the security. Probably, the most
 * bang for the buck is, in any enterprise frobulator project, that you assert the security setup - told you so.
 */
@WebMvcTest
@ContextConfiguration(classes = { ApiConfig.class, SecurityConfig.class })
class ApiRestControllerIT {

    @MockBean
    FrobulatorApiAccess access;

    @Autowired
    MockMvc mockMvc;

    @Test
    void ensureRedirectForUnauthorized() throws Exception {

        mockMvc.perform(get("/api"))
            .andExpect(status().is3xxRedirection());
    }


    @Test
    @WithAnonymousUser
    void ensureRedirectForAnonymous() throws Exception {

        mockMvc.perform(get("/api"))
            .andExpect(status().is3xxRedirection());
    }


    @Test
    @WithMockUser(roles = "OTHER")
    void ensureForbiddenForOtherRole() throws Exception {

        mockMvc.perform(get("/api"))
            .andExpect(status().isForbidden());
    }


    @Test
    @WithMockUser(roles = "DEVELOPER")
    void ensureShowsLinksToApiV1AndSelf() throws Exception {

        mockMvc.perform(get("/api"))
            .andExpect(status().isOk());
    }
}
