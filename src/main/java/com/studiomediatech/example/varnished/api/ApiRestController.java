package com.studiomediatech.example.varnished.api;

import com.studiomediatech.example.varnished.api.frobulator.ApiFrobulator;

import org.springframework.hateoas.Link;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


/**
 * Yeah, always be naming your classes in an enterprisey manner. This is no joke. A nice and neat suffix-superfluous
 * naming schema never hurt anyone. On the contrary, it's been the back-bone of this Java toutin' industry for years
 * and years. Get over it.
 */
@RestController
public class ApiRestController {

    private static final String FROBULATORS_PATH = "/api/v1/frobulators";

    public static final Function<String, Link> API = rel ->
            linkTo(methodOn(ApiRestController.class).api()).withRel(rel);

    public static final Function<String, Link> API_V1 = rel ->
            linkTo(methodOn(ApiRestController.class).v1()).withRel(rel);

    public static final Function<String, Link> API_V1_FROBULATORS = rel ->
            linkTo(methodOn(ApiRestController.class).frobulators()).withRel(rel);

    private final ApiRestControllerAdapter adapter;

    public ApiRestController(Optional<ApiRestControllerAdapter> maybe) {

        this.adapter = maybe.orElseGet(ApiRestControllerAdapter::instance);
    }

    @GetMapping("/api")
    public Map<String, Object> api() {

        return Collections.singletonMap("links", List.of(API.apply("self"), API_V1.apply("v1")));
    }


    @GetMapping("/api/v1")
    public Map<String, Object> v1() {

        return Collections.singletonMap("links",
                List.of(API.apply("parent"), API_V1.apply("self"), API_V1_FROBULATORS.apply("frobulators")));
    }


    @GetMapping(FROBULATORS_PATH)
    public Collection<ApiFrobulator> frobulators() {

        return adapter.frobulators();
    }


    @PostMapping(path = FROBULATORS_PATH, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addFrobulator(@RequestBody ApiFrobulator frobulator) {

        return adapter.addFrobulator(frobulator);
    }
}
