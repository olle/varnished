package com.studiomediatech.example.varnished.api.config;

import com.studiomediatech.example.varnished.api.Api;
import com.studiomediatech.example.varnished.api.ApiRestControllerAdapter;
import com.studiomediatech.example.varnished.api.frobulator.ApiFrobulator;
import com.studiomediatech.example.varnished.api.frobulator.ApiFrobulators;
import com.studiomediatech.example.varnished.api.frobulator.FrobulatorApiAccess;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import org.springframework.http.ResponseEntity;

import java.util.Collection;


/**
 * This configures the API module, assuming strict separation with any application logic - that stuff belongs in the
 * app.
 */
@Configuration
@ComponentScan(basePackageClasses = Api.class)
public class ApiConfig {

    @Bean
    ApiFrobulators apiFrobulators(FrobulatorApiAccess apiAccess) {

        return new ApiFrobulators(apiAccess);
    }


    @Bean
    public ApiRestControllerAdapter apiRestControllerAdapter(ApiFrobulators apiFrobulators) {

        return new ApiRestControllerAdapter() {

            @Override
            public Collection<ApiFrobulator> frobulators() {

                return apiFrobulators.listFrobulators();
            }


            @Override
            public ResponseEntity<Void> addFrobulator(ApiFrobulator frobulator) {

                return apiFrobulators.addFrobulator(frobulator);
            }
        };
    }
}
