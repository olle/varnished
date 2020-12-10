package com.studiomediatech.example.varnished.web;

import com.studiomediatech.example.varnished.web.frobulator.FrobulatorForm;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

import javax.validation.Valid;


/**
 * Especially for handling those frobulator needs.
 */
@Controller
public class FrobulatorController {

    private final FrobulatorControllerAdapter adapter;

    public FrobulatorController(Optional<FrobulatorControllerAdapter> adapter) {

        this.adapter = adapter.orElseGet(FrobulatorControllerAdapter::instance);
    }

    @GetMapping("/frobulators/new")
    public String newFrobulator(Model model) {

        return adapter.newFrobulator(model);
    }


    @GetMapping("/frobulators/{key}")
    public String frobulatorDetails(Model model,
        @PathVariable("key") String key) {

        return adapter.frobulatorDetails(model, key);
    }


    @DeleteMapping("/frobulators/{key}")
    public String deleteFrobulator(Model model,
        @PathVariable("key") String key) {

        return adapter.deleteFrobulator(model, key);
    }


    @PostMapping("/frobulators")
    public String createFrobulator(Model model, //
        @Valid FrobulatorForm form, BindingResult errors, RedirectAttributes redirect) {

        return adapter.createFrobulator(model, form, errors, redirect);
    }
}
