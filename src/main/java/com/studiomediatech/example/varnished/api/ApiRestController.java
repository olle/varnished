package com.studiomediatech.example.varnished.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;


/**
 * Yeah, always be naming your classes in an enterprisey manner. This is no joke. A nice and neat suffix-superfluous
 * naming schema never hurt anyone. On the contrary, it's been the back-bone of this Java toutin' industry for years
 * and years. Get over it.
 */
@RestController
public class ApiRestController {

    @GetMapping("/")
    public Map<String, Object> api() {

        return Collections.singletonMap("foo", "bar");
    }
}
