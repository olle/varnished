package com.studiomediatech.example.varnished.app.frobulator;

import java.util.Collection;
import java.util.Optional;


/**
 * This is another adapter layer. You'll thank me later, I promise. You're in enterprise software world now, and no one
 * can hear you scream.
 */
public interface FrobulatorDao {

    Collection<Frobulator> listAllFrobulators();


    void saveNewFrobulator(Frobulator frobulator);


    Optional<Frobulator> deleteFrobulatorById(long id);


    Optional<Frobulator> deleteFrobulatorByName(String name);


    Optional<Frobulator> getFrobulatorByName(String name);
}
