package example.varnished.app.config;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.security.test.context.support.WithMockUser;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import example.varnished.infra.config.SecurityConfig;
import example.varnished.infra.config.WebConfig;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest
@ContextConfiguration(classes = { WebConfig.class, SecurityConfig.class })
class WebSecurityConfigIT {

    @Autowired
    MockMvc mockMvc;

    @Test
    void ensureUnauthenticatedAreRedirectedToLogin() throws Exception {

        mockMvc.perform(get("/")).andExpect(status().is3xxRedirection());
    }


    @Test
    @WithMockUser(roles = "OTHER")
    void ensureOthersAreForbidden() throws Exception {

        mockMvc.perform(get("/")).andExpect(status().isForbidden());
    }


    @Test
    @WithMockUser(roles = "DEVELOPER")
    void ensureDevelopersHasAccess() throws Exception {

        mockMvc.perform(get("/")).andExpect(status().is2xxSuccessful());
    }
}
