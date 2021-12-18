package example.varnished.app.config;

import org.springframework.context.annotation.Configuration;

import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private Environment env;

    public SecurityConfig(Environment env) {

        this.env = env;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        if (env.acceptsProfiles(Profiles.of("dev"))) {
            auth.inMemoryAuthentication().withUser("dev").password("{noop}dev").roles("DEVELOPER");
        }
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests().antMatchers("/**").hasAnyRole("DEVELOPER");
        http.formLogin().permitAll();
    }
}
