package com.studiomediatech.example.varnished.app.event;

public final class DeletedFrobulatorEvent {

    private final String name;

    private DeletedFrobulatorEvent(String name) {

        this.name = name;
    }

    public String getName() {

        return name;
    }


    @Override
    public String toString() {

        return "DeletedFrobulatorEvent [name=" + name + "]";
    }


    public static DeletedFrobulatorEvent valueOf(String name) {

        return new DeletedFrobulatorEvent(name);
    }
}
