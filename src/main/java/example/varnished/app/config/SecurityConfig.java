package example.varnished.app.config;

import example.varnished.app.VarninshedApp;

import org.springframework.context.annotation.Configuration;

import org.springframework.core.env.Environment;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private Environment env;

    public SecurityConfig(Environment env) {

        this.env = env;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        if (env.acceptsProfiles(VarninshedApp.DEV_PROFILE)) {
            auth.inMemoryAuthentication().withUser("dev").password("{noop}dev").roles("DEVELOPER");
        }
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests().antMatchers("/**").hasAnyRole("DEVELOPER");
        http.formLogin().permitAll();
    }


    @Override
    public void configure(WebSecurity web) throws Exception {

        // FOR TOGGLING! // web.ignoring().antMatchers("/api/**").anyRequest();
    }
}
