package com.studiomediatech.example.varnished.web.config;

import com.studiomediatech.example.varnished.web.Web;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


/**
 * Imported from the application configuration, and isolated here for optional tests or integration test-setups, that
 * makes life easier.
 */
@Configuration
@ComponentScan(basePackageClasses = Web.class)
public class WebConfig {

    // OK
}
