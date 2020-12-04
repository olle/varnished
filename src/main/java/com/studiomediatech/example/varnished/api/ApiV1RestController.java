package com.studiomediatech.example.varnished.api;

import org.springframework.hateoas.Link;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.function.Function;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


/**
 * So, we're moving into the world of API wonders, this can now provide a developer-friendly index of some of the
 * available resources under version 1 - you do speak HATEOAS, do you?
 */
@RestController
public class ApiV1RestController {

    static final Function<String, Link> API_V1_LINK = rel ->
            linkTo(methodOn(ApiV1RestController.class).v1()).withRel(rel);

    @GetMapping("/api/v1")
    public Map<String, Object> v1() {

        Link l1 = ApiRestController.API_LINK.apply("parent");
        Link l2 = ApiV1RestController.API_V1_LINK.apply("self");

        return Collections.singletonMap("links", Arrays.asList(l1, l2));
    }
}
