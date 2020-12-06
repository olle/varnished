package com.studiomediatech.example.varnished.app.frobulator;

import com.studiomediatech.example.varnished.api.frobulator.FrobulatorApiAccess;
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

    public FrobulatorService(FrobulatorDao dao) {

        this.dao = dao;
    }

    @Override
    public Collection<Frobulator> listFrobulatorsForWeb() {

        return dao.listAllFrobulators();
    }


    @Override
    public Collection<Frobulator> listFrobulatorsForApi() {

        return dao.listAllFrobulators();
    }
}
