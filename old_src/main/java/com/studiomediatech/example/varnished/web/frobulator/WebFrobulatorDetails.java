package com.studiomediatech.example.varnished.web.frobulator;

import com.studiomediatech.example.varnished.app.frobulator.Frobulator;


public class WebFrobulatorDetails {

    private final String name;

    private WebFrobulatorDetails(String name) {

        this.name = name;
    }

    public String getName() {

        return name;
    }


    @Override
    public String toString() {

        return "WebFrobulatorDetails [name=" + name + "]";
    }


    public static WebFrobulatorDetails fromFrobulator(Frobulator frobulator) {

        return new WebFrobulatorDetails(frobulator.getName());
    }
}
