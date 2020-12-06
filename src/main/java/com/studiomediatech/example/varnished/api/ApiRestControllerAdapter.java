package com.studiomediatech.example.varnished.api;

import com.studiomediatech.example.varnished.api.frobulator.ApiFrobulator;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collection;
import java.util.Collections;


/**
 * This is always a pointless and empty default, but hey, no one ever said this was supposed to be funny. It takes the
 * soul and crushes it, before it gets the hose again.
 */
public interface ApiRestControllerAdapter {


    default Collection<ApiFrobulator> frobulators() {

        return Collections.emptyList();
    }


    default ResponseEntity<Void> addFrobulator(ApiFrobulator frobulator) {

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    static ApiRestControllerAdapter instance() {

        return new ApiRestControllerAdapter() {

            // OK
        };
    }
}
