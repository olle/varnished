package com.studiomediatech.example.varnished.web.frobulator;

import java.util.Collection;
import java.util.List;


/**
 * Adapter (AGAIN!) to any possible access to a list of frobulators, but we are responsible for transforming any core
 * models or domain objects into pretty little web-frobulator instances.
 */
public class WebFrobulators {

    public Collection<WebFrobulator> list() {

        return List.of(WebFrobulator.valueOf("foo"), WebFrobulator.valueOf("bar"), WebFrobulator.valueOf("baz"));
    }
}
