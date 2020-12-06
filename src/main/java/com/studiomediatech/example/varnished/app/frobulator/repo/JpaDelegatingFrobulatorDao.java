package com.studiomediatech.example.varnished.app.frobulator.repo;

import com.studiomediatech.example.varnished.app.frobulator.Frobulator;
import com.studiomediatech.example.varnished.app.frobulator.FrobulatorDao;

import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Component
public class JpaDelegatingFrobulatorDao implements FrobulatorDao {

    private final FrobulatorEntityRepository repo;

    public JpaDelegatingFrobulatorDao(FrobulatorEntityRepository repo) {

        this.repo = repo;
    }

    @Override
    public Collection<Frobulator> listAllFrobulators() {

        return StreamSupport.stream(repo.findAll().spliterator(), false)
            .map(FrobulatorEntity::toFrobulator)
            .collect(Collectors.toList());
    }
}
