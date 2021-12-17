package com.studiomediatech.example.varnished.api.frobulator;

import com.fasterxml.jackson.annotation.JsonProperty;

import com.studiomediatech.example.varnished.app.frobulator.Frobulator;


/**
 * The frobulator of your dreams, just perfectly suitable for REST-ful frobulation, go figure.
 */
public class ApiFrobulator {

    @JsonProperty
    public String name;

    public static ApiFrobulator fromFrobulator(Frobulator frobulator) {

        ApiFrobulator target = new ApiFrobulator();
        target.name = frobulator.getName();

        return target;
    }


    public Frobulator toFrobulator() {

        return new Frobulator(name);
    }
}
