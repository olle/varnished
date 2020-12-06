package com.studiomediatech.example.varnished.web.frobulator;

import java.util.Collection;
import java.util.stream.Collectors;


/**
 * Adapter (AGAIN!) to any possible access to a list of frobulators, but we are responsible for transforming any core
 * models or domain objects into pretty little web-frobulator instances.
 */
public class WebFrobulators {

    private final FrobulatorWebAccess webAccess;

    public WebFrobulators(FrobulatorWebAccess frobulatorWebAccess) {

        this.webAccess = frobulatorWebAccess;
    }

    public Collection<WebFrobulator> list() {

        return webAccess.listFrobulatorsForWeb()
            .stream()
            .map(WebFrobulator::fromFrobulator)
            .collect(Collectors.toList());
    }
}
