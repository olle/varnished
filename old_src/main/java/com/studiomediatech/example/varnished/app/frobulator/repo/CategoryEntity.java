package com.studiomediatech.example.varnished.app.frobulator.repo;

import org.springframework.data.jpa.domain.AbstractPersistable;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;


@Entity
@Table(name = "categories")
class CategoryEntity extends AbstractPersistable<Long> {

    @Column(length = 64, nullable = false, unique = true, name = "name")
    private String name;

    @OneToMany(mappedBy = "category")
    @OrderBy("name")
    private List<FrobulatorEntity> frobulators;

    public String getName() {

        return name;
    }


    public void setName(String name) {

        this.name = name;
    }


    @Override
    public String toString() {

        return "CategoryEntity [name=" + name + "]";
    }
}
