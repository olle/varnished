package com.studiomediatech.example.varnished.web;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;


/**
 * Serving those hungry hungry hippos!
 */
@Controller
public class RootController {

    private final RootControllerAdapter adapter;

    public RootController(Optional<RootControllerAdapter> maybe) {

        adapter = maybe.orElseGet(RootControllerAdapter::instance);
    }

    @GetMapping("/")
    public String index(Model model) {

        return adapter.index(model);
    }
}
