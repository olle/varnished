package com.studiomediatech.example.varnished.web.config;

import com.studiomediatech.example.varnished.web.FrobulatorControllerAdapter;
import com.studiomediatech.example.varnished.web.RootControllerAdapter;
import com.studiomediatech.example.varnished.web.Web;
import com.studiomediatech.example.varnished.web.frobulator.FrobulatorForm;
import com.studiomediatech.example.varnished.web.frobulator.FrobulatorWebAccess;
import com.studiomediatech.example.varnished.web.frobulator.WebFrobulators;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import org.springframework.ui.Model;

import org.springframework.validation.BindingResult;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;


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

            // OK
        };
    }


    @Bean
    public FrobulatorControllerAdapter frobulatorControllerAdapter(WebFrobulators webFrobulators) {

        return new FrobulatorControllerAdapter() {

            @Override
            public String listFrobulators(Model model) {

                return webFrobulators.listFrobulators(model);
            }


            @Override
            public String frobulatorDetails(Model model, String key) {

                return webFrobulators.frobulatorDetails(model, key);
            }


            @Override
            public String deleteFrobulator(Model model, String key) {

                return webFrobulators.deleteFrobulator(model, key);
            }


            @Override
            public String createFrobulator(Model model, FrobulatorForm form, BindingResult errors,
                RedirectAttributes redirect) {

                return webFrobulators.createFrobulator(model, form, errors, redirect);
            }
        };
    }
}
