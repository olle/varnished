package com.studiomediatech.example.varnished.web.frobulator;

import com.studiomediatech.example.varnished.app.frobulator.Frobulator;

import java.util.Collection;
import java.util.Optional;


/**
 * We declare how we can access frobulators from the "outside", we cannot know how the "inside" implements this.
 */
public interface FrobulatorWebAccess {

    Collection<Frobulator> listFrobulatorsForWeb();


    Optional<Frobulator> getFrobulatorByNameForWeb(String name);
}
