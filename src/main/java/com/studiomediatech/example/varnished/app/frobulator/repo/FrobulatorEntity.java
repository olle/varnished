package com.studiomediatech.example.varnished.app.frobulator.repo;

import com.studiomediatech.example.varnished.app.frobulator.Frobulator;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * Just never take the easy way out, having table names auto-generated. Stuff like that is just play-time crap. Dev-up
 * and take it to the face - explicit table names and columns; ALWAYS.
 */
@Entity
@Table(name = "frobulators")
class FrobulatorEntity extends AbstractPersistable<Long> {

    @Column(length = 64, nullable = false, name = "name")
    private String name;

    public String getName() {

        return name;
    }


    public void setName(String name) {

        this.name = name;
    }


    @Override
    public String toString() {

        return "FrobulatorEntity [name=" + name + "]";
    }


    public Frobulator toFrobulator() {

        return new Frobulator(name);
    }


    public static FrobulatorEntity valueOf(Frobulator frobulator) {

        FrobulatorEntity target = new FrobulatorEntity();
        target.setName(frobulator.getName());

        return target;
    }
}
