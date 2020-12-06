package com.studiomediatech.example.varnished.app.frobulator.repo;

import com.studiomediatech.example.varnished.app.frobulator.Frobulator;
import com.studiomediatech.example.varnished.app.frobulator.FrobulatorDao;

import org.springframework.stereotype.Component;

import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Component
public class JpaDelegatingFrobulatorDao implements FrobulatorDao {

    private final FrobulatorEntityRepository repo;

    public JpaDelegatingFrobulatorDao(FrobulatorEntityRepository repo) {

        this.repo = repo;
    }

    @Transactional(readOnly = true)
    @Override
    public Collection<Frobulator> listAllFrobulators() {

        return StreamSupport.stream(repo.findAll().spliterator(), false)
            .map(FrobulatorEntity::toFrobulator)
            .collect(Collectors.toList());
    }


    @Transactional
    @Override
    public void saveNewFrobulator(Frobulator frobulator) {

        FrobulatorEntity entity = FrobulatorEntity.valueOf(frobulator);
        repo.save(entity);
    }


    @Transactional
    @Override
    public Optional<Frobulator> deleteFrobulatorById(long id) {

        Optional<Frobulator> maybe = repo.findById(id).map(FrobulatorEntity::toFrobulator);
        repo.deleteById(id);

        return maybe;
    }


    @Transactional
    @Override
    public Optional<Frobulator> deleteFrobulatorByName(String name) {

        Optional<Frobulator> maybe = repo.findOneByName(name).map(FrobulatorEntity::toFrobulator);
        repo.deleteByName(name);

        return maybe;
    }
}
