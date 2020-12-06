package com.studiomediatech.example.varnished.api.frobulator;

import java.util.Collection;
import java.util.stream.Collectors;


/**
 * So, yeah. He he he... can't go wrong with another level of indirection.
 */
public class ApiFrobulators {

    private final FrobulatorApiAccess apiAccess;

    public ApiFrobulators(FrobulatorApiAccess apiAccess) {

        this.apiAccess = apiAccess;
    }

    public Collection<ApiFrobulator> listFrobulators() {

        return apiAccess.listFrobulatorsForApi()
            .stream()
            .map(ApiFrobulator::fromFrobulator)
            .collect(Collectors.toList());
    }
}
