package com.studiomediatech.example.varnished.api;

import org.springframework.hateoas.Link;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Map;
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

    public static final Function<String, Link> API = rel ->
            linkTo(methodOn(ApiRestController.class).api()).withRel(rel);

    public static final Function<String, Link> API_V1 = rel ->
            linkTo(methodOn(ApiRestController.class).v1()).withRel(rel);

    @GetMapping("/api")
    public Map<String, Object> api() {

        return Collections.singletonMap("links", List.of(API.apply("self"), API_V1.apply("v1")));
    }


    @GetMapping("/api/v1")
    public Map<String, Object> v1() {

        return Collections.singletonMap("links", List.of(API.apply("parent"), API_V1.apply("self")));
    }
}
