package com.studiomediatech.example.varnished.app.config;

import com.studiomediatech.example.varnished.api.config.ApiConfig;
import com.studiomediatech.example.varnished.event.EventEmitter;
import com.studiomediatech.example.varnished.web.WebConfig;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Date;


/**
 * This is your typical, context less base configuration for the application. We're using imports to create more
 * manageable modules, which incidentally can be loading independently in tests. You'll thank me later!
 */
@Configuration
@EnableScheduling
@Import({ ApiConfig.class, WebConfig.class })
public class VarnishedApplicationConfig {

    @Bean
    @ConditionalOnMissingBean
    public EventEmitter eventEmitter(ApplicationEventPublisher publisher, TaskScheduler taskScheduler) {

        return event ->
                taskScheduler.schedule(() -> publisher.publishEvent(event), new Date(System.currentTimeMillis()));
    }
}
