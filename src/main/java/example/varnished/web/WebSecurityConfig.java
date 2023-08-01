package example.varnished.web;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
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
                User.withUsername("user").password("user").roles("USER").build(),
                User.withUsername("dev").password("dev").roles("DEVELOPER").build(),
                User.withUsername("other").password("other").roles("OTHER").build());
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.formLogin(Customizer.withDefaults());

        http.authorizeHttpRequests(
                authz -> authz.requestMatchers("/**").hasAnyRole("DEVELOPER").anyRequest().authenticated());

        return http.build();
    }
}
