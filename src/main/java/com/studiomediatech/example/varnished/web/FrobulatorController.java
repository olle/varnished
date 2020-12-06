package com.studiomediatech.example.varnished.web;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;


/**
 * Especially for handling those frobulator needs.
 */
@Controller
public class FrobulatorController {

    private final FrobulatorControllerAdapter adapter;

    public FrobulatorController(Optional<FrobulatorControllerAdapter> adapter) {

        this.adapter = adapter.orElseGet(FrobulatorControllerAdapter::instance);
    }

    @GetMapping("/frobulators/{key}")
    public String frobulatorDetails(Model model,
        @PathVariable("key") String key) {

        return adapter.frobulatorDetails(model, key);
    }
}
