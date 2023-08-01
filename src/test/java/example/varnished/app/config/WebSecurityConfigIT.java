package example.varnished.app.config;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import example.varnished.web.WebConfig;

/**
 * Using custom context configuration here, allows us to avoid running a heavier application context. Since we only
 * really want to assert the role based access rules, it's well and enough to run controllers, with default (empty) web
 * adapters, and the security configuration.
 *
 * <p>
 * Being dependent on {@code SpringBootTest} setups, and all other layers or modules in the application, is too time and
 * resource intensive for the value proposition here - testing simple access.
 * </p>
 */
@WebMvcTest
@ContextConfiguration(classes = { WebConfig.class })
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
