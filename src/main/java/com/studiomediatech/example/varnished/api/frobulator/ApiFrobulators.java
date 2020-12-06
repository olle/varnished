package com.studiomediatech.example.varnished.api.frobulator;

import com.studiomediatech.example.varnished.app.frobulator.Frobulator;
import com.studiomediatech.example.varnished.utils.Logging;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collection;
import java.util.stream.Collectors;


/**
 * So, yeah. He he he... can't go wrong with another level of indirection.
 */
public class ApiFrobulators implements Logging {

    private final FrobulatorApiAccess apiAccess;

    public ApiFrobulators(FrobulatorApiAccess apiAccess) {

        this.apiAccess = apiAccess;
    }

    public Collection<ApiFrobulator> listFrobulators() {

        return apiAccess.listFrobulatorsForApi()
            .stream()
            .map(ApiFrobulator::fromFrobulator)
            .collect(Collectors.toList());
    }


    public ResponseEntity<Void> addFrobulator(ApiFrobulator frobulator) {

        try {
            Frobulator f = frobulator.toFrobulator();
            apiAccess.addFrobulatorFromApi(f);

            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (RuntimeException ex) {
            logger().debug("Failed to add frobulator", ex);

            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
