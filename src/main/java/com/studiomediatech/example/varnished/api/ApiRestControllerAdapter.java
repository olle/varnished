package com.studiomediatech.example.varnished.api;

import com.studiomediatech.example.varnished.api.frobulator.ApiFrobulator;

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


    static ApiRestControllerAdapter instance() {

        return new ApiRestControllerAdapter() {

            // OK
        };
    }
}
