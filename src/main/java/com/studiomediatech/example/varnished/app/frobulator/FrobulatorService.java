package com.studiomediatech.example.varnished.app.frobulator;

import com.studiomediatech.example.varnished.api.frobulator.FrobulatorApiAccess;
import com.studiomediatech.example.varnished.app.event.AddedNewFrobulatorEvent;
import com.studiomediatech.example.varnished.event.EventEmitter;
import com.studiomediatech.example.varnished.web.frobulator.FrobulatorWebAccess;

import org.springframework.stereotype.Service;

import java.util.Collection;


/**
 * Let's start out with a classic - a service, that can serve some served purpose. This is a concrete component, just
 * wire it up and watch it gooooo!
 */
@Service
public class FrobulatorService implements FrobulatorWebAccess, FrobulatorApiAccess {

    private final FrobulatorDao dao;
    private final EventEmitter emitter;

    public FrobulatorService(FrobulatorDao dao, EventEmitter emitter) {

        this.dao = dao;
        this.emitter = emitter;
    }

    @Override
    public Collection<Frobulator> listFrobulatorsForWeb() {

        return dao.listAllFrobulators();
    }


    @Override
    public Collection<Frobulator> listFrobulatorsForApi() {

        return dao.listAllFrobulators();
    }


    @Override
    public void addFrobulatorFromApi(Frobulator frobulator) {

        dao.saveNewFrobulator(frobulator);
        emitter.emitEvent(AddedNewFrobulatorEvent.valueOf(frobulator.getName()));
    }
}