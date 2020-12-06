package com.studiomediatech.example.varnished.app.event;

public final class AddedNewFrobulatorEvent {

    private final String name;

    private AddedNewFrobulatorEvent(String name) {

        this.name = name;
    }

    public String getName() {

        return name;
    }


    @Override
    public String toString() {

        return "AddedNewFrobulatorEvent [name=" + name + "]";
    }


    public static AddedNewFrobulatorEvent valueOf(String name) {

        return new AddedNewFrobulatorEvent(name);
    }
}
