package com.studiomediatech.example.varnished.web;

import java.util.function.BiConsumer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.studiomediatech.example.varnished.web.frobulator.FrobulatorControllerAdapter;
import com.studiomediatech.example.varnished.web.frobulator.FrobulatorWebAccess;
import com.studiomediatech.example.varnished.web.frobulator.NewFrobulatorForm;
import com.studiomediatech.example.varnished.web.frobulator.WebFrobulators;

/**
 * Imported from the application configuration, and isolated here for optional
 * tests or integration test-setups, that makes life easier.
 */
@Configuration
@ComponentScan(basePackageClasses = Web.class)
public class WebConfig {

    @Bean
    public WebFacade webFacade(FrobulatorControllerAdapter frobulatorControllerAdapter) {

        return new WebFacade(frobulatorControllerAdapter);
    }

    @Bean
    WebFrobulators webFrobulators(FrobulatorWebAccess webAccess) {

        return new WebFrobulators(webAccess);
    }

    @Bean
    public FrobulatorControllerAdapter frobulatorControllerAdapter(WebFrobulators webFrobulators) {

        return new FrobulatorControllerAdapter() {

            @Override
            public String listFrobulators(BiConsumer<String, Object> sink) {

                return webFrobulators.listFrobulators(sink);
            }

            @Override
            public String frobulatorDetails(BiConsumer<String, Object> sink, String key) {

                return webFrobulators.frobulatorDetails(sink, key);
            }

            @Override
            public String editFrobulator(BiConsumer<String, Object> sink, String key) {

                return webFrobulators.editFrobulator(sink, key);
            }

            @Override
            public String deleteFrobulator(BiConsumer<String, Object> sink, String key) {

                return webFrobulators.deleteFrobulator(sink, key);
            }

            @Override
            public String createFrobulator(BiConsumer<String, Object> sink, NewFrobulatorForm form,
                    BindingResult errors, RedirectAttributes redirect) {

                return webFrobulators.createFrobulator(sink, form, errors, redirect);
            }
        };
    }
}
