package com.studiomediatech.example.varnished.web.frobulator;

import com.studiomediatech.example.varnished.app.frobulator.Frobulator;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class FrobulatorForm {

    @NotNull
    @Size(min = 2, max = 64)
    private String name;

    public String getName() {

        return name;
    }


    public void setName(String name) {

        this.name = name;
    }


    public Frobulator toFrobulator() {

        return new Frobulator(name);
    }
}
