package com.studiomediatech.example.varnished.app.frobulator;

import com.studiomediatech.example.varnished.api.frobulator.FrobulatorApiAccess;
import com.studiomediatech.example.varnished.app.event.AddedNewFrobulatorEvent;
import com.studiomediatech.example.varnished.app.event.DeletedFrobulatorEvent;
import com.studiomediatech.example.varnished.event.EventEmitter;
import com.studiomediatech.example.varnished.web.frobulator.FrobulatorWebAccess;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;


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
    public Optional<Frobulator> getFrobulatorByNameForWeb(String name) {

        return dao.getFrobulatorByName(name);
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


    @Override
    public void deleteFrobulatorById(long id) {

        onDeleted(dao.deleteFrobulatorById(id));
    }


    @Override
    public void deleteFrobulatorByName(String name) {

        onDeleted(dao.deleteFrobulatorByName(name));
    }


    private void onDeleted(Optional<Frobulator> maybe) {

        maybe.map(Frobulator::getName).ifPresent(name -> emitter.emitEvent(DeletedFrobulatorEvent.valueOf(name)));
    }
}
