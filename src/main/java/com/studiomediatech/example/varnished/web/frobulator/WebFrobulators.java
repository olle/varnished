package com.studiomediatech.example.varnished.web.frobulator;

import com.studiomediatech.example.varnished.app.frobulator.Frobulator;

import java.nio.charset.StandardCharsets;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Adapter (AGAIN!) to any possible access to a list of frobulators, but we are responsible for transforming any core
 * models or domain objects into pretty little web-frobulator instances.
 */
public class WebFrobulators {

    private final FrobulatorWebAccess webAccess;

    private Map<String, String> index = new ConcurrentHashMap<>();

    public WebFrobulators(FrobulatorWebAccess frobulatorWebAccess) {

        this.webAccess = frobulatorWebAccess;
    }

    public Optional<WebFrobulatorDetails> getFrobulatorDetails(String key) {

        String name = index.get(key);

        if (name == null) {
            return Optional.empty();
        }

        return webAccess.getFrobulatorByNameForWeb(name)
            .map(WebFrobulatorDetails::fromFrobulator);
    }


    public Collection<WebFrobulator> list() {

        Collection<Frobulator> frobulators = webAccess.listFrobulatorsForWeb();

        List<WebFrobulator> results = new ArrayList<>();

        for (Frobulator frobulator : frobulators) {
            String key = mapToKey(frobulator);

            WebFrobulator webFrobulator = WebFrobulator.fromFrobulator(frobulator);
            webFrobulator.setKey(key);

            results.add(webFrobulator);
        }

        return results;
    }


    private String mapToKey(Frobulator frobulator) {

        String key = calculateKey(frobulator);
        index.put(key, frobulator.getName());

        return key;
    }


    private static String calculateKey(Frobulator frobulator) {

        return UUID.nameUUIDFromBytes(("secret-" + frobulator.getName()).getBytes(StandardCharsets.UTF_8))
            .toString();
    }
}
