package com.studiomediatech.example.varnished.api.config;

import com.studiomediatech.example.varnished.api.Api;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


/**
 * This configures the API module, assuming strict separation with any application logic - that stuff belongs in the
 * app.
 */
@Configuration
@ComponentScan(basePackageClasses = Api.class)
public class ApiConfig {

    // OK
}
