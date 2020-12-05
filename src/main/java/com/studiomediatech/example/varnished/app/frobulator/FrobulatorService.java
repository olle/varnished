package com.studiomediatech.example.varnished.app.frobulator;

import com.studiomediatech.example.varnished.web.frobulator.FrobulatorWebAccess;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;


/**
 * Let's start out with a classic - a service, that can serve some served purpose. This is a concrete component, just
 * wire it up and watch it gooooo!
 */
@Service
public class FrobulatorService implements FrobulatorWebAccess {

    @Override
    public Collection<Frobulator> listFrobulatorsForWeb() {

        return Collections.emptyList();
    }
}
