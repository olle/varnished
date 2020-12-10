package com.studiomediatech.example.varnished.api.frobulator;

import com.studiomediatech.example.varnished.app.frobulator.Frobulator;

import java.util.Collection;


public interface FrobulatorApiAccess {

    Collection<Frobulator> listFrobulatorsForApi();


    void addFrobulatorFromApi(Frobulator frobulator);


    void deleteFrobulatorFromApiById(long id);


    void deleteFrobulatorFromApiByName(String name);
}
