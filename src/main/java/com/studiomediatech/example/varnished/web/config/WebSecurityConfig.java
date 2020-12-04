package com.studiomediatech.example.varnished.web.config;

import com.studiomediatech.example.varnished.app.VarnishedApplication;

import org.springframework.context.annotation.Configuration;

import org.springframework.core.env.Environment;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private Environment env;

    public WebSecurityConfig(Environment env) {

        this.env = env;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        if (env.acceptsProfiles(VarnishedApplication.DEVELOPMENT)) {
            auth.inMemoryAuthentication().withUser("user").password("{noop}user").roles("USER");
            auth.inMemoryAuthentication().withUser("admin").password("{noop}admin").roles("ADMIN");
        }
    }
}
