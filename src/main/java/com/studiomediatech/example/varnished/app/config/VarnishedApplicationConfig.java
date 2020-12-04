package com.studiomediatech.example.varnished.app.config;

import com.studiomediatech.example.varnished.api.config.ApiConfig;
import com.studiomediatech.example.varnished.web.config.WebConfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


/**
 * This is your typical, context less base configuration for the application. We're using imports to create more
 * manageable modules, which incidentally can be loading independently in tests. You'll thank me later!
 */
@Configuration
@Import({ ApiConfig.class, WebConfig.class })
public class VarnishedApplicationConfig {

    // OK
}
