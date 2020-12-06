package com.studiomediatech.example.varnished.web.config;

import com.studiomediatech.example.varnished.web.FrobulatorControllerAdapter;
import com.studiomediatech.example.varnished.web.RootControllerAdapter;
import com.studiomediatech.example.varnished.web.Web;
import com.studiomediatech.example.varnished.web.frobulator.FrobulatorWebAccess;
import com.studiomediatech.example.varnished.web.frobulator.WebFrobulators;

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
    WebFrobulators webFrobulators(FrobulatorWebAccess webAccess) {

        return new WebFrobulators(webAccess);
    }


    @Bean
    public RootControllerAdapter rootControllerAdapter(WebFrobulators webFrobulators) {

        return new RootControllerAdapter() {

            @Override
            public String index(Model model) {

                return webFrobulators.index(model);
            }
        };
    }


    @Bean
    public FrobulatorControllerAdapter frobulatorControllerAdapter(WebFrobulators webFrobulators) {

        return new FrobulatorControllerAdapter() {

            @Override
            public String frobulatorDetails(Model model, String key) {

                return webFrobulators.frobulatorDetails(model, key);
            }
        };
    }
}
