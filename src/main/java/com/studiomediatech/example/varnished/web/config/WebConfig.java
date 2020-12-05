package com.studiomediatech.example.varnished.web.config;

import com.studiomediatech.example.varnished.web.RootControllerAdapter;
import com.studiomediatech.example.varnished.web.Web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import org.springframework.ui.Model;


/**
 * Imported from the application configuration, and isolated here for optional tests or integration test-setups, that
 * makes life easier.
 */
@Configuration
@ComponentScan(basePackageClasses = Web.class)
public class WebConfig {

    @Bean
    public RootControllerAdapter rootControllerAdapter() {

        return new RootControllerAdapter() {

            @Override
            public String index(Model model) {

                model.addAttribute("name", "Roger");

                return "index";
            }
        };
    }
}
