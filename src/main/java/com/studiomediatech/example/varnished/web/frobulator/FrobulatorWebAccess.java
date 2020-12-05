package com.studiomediatech.example.varnished.web.frobulator;

import com.studiomediatech.example.varnished.app.frobulator.Frobulator;

import java.util.Collection;


/**
 * We declare how we can access frobulators from the "outside", we cannot know how the "inside" implements this.
 */
public interface FrobulatorWebAccess {

    Collection<Frobulator> listFrobulatorsForWeb();
}
