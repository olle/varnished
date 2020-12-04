package com.studiomediatech.example.varnished.api;

import com.studiomediatech.example.varnished.api.v1.ApiV1RestController;

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
 * Yeah, always be naming your classes in an enterprisey manner. This is no joke. A nice and neat suffix-superfluous
 * naming schema never hurt anyone. On the contrary, it's been the back-bone of this Java toutin' industry for years
 * and years. Get over it.
 */
@RestController
public class ApiRestController {

    public static final Function<String, Link> API_LINK = rel ->
            linkTo(methodOn(ApiRestController.class).api()).withRel(rel);

    @GetMapping("/api")
    public Map<String, Object> api() {

        Link l1 = ApiRestController.API_LINK.apply("self");
        Link l2 = ApiV1RestController.API_V1_LINK.apply("v1");

        return Collections.singletonMap("links", Arrays.asList(l1, l2));
    }
}
