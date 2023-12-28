package example.varnished.web;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
class WebSecurityConfig {

    @Bean
    @ConditionalOnMissingBean
    public UserDetailsService defaultUserDetailsService() {
        return new InMemoryUserDetailsManager( // NOSONAR
                User.withUsername("admin").password("{noop}admin").roles("ADMIN").build(),
                User.withUsername("user").password("{noop}user").roles("USER").build(),
                User.withUsername("dev").password("{noop}dev").roles("DEVELOPER").build(),
                User.withUsername("other").password("{noop}other").roles("OTHER").build());
    }

    @Bean("endpoint-security-chain")
    public SecurityFilterChain endpointSecurityFilterChain(HttpSecurity http) throws Exception {
        http.securityMatcher(EndpointRequest.toAnyEndpoint());
        http.authorizeHttpRequests(authz -> authz.anyRequest().hasRole("ADMIN")).formLogin(withDefaults())
                .logout(withDefaults());
        return http.build();
    }

    @Bean("web-mvc-security-chain")
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authz()).formLogin(withDefaults()).logout(withDefaults());
        return http.build();
    }

    private Customizer<AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry> authz() {
        return authz -> authz.requestMatchers("/**").hasAnyRole("DEVELOPER") // NOSONAR
                .anyRequest().denyAll();
    }
}
