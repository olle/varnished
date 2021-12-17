package com.studiomediatech.example.varnished.web;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.studiomediatech.example.varnished.web.frobulator.NewFrobulatorForm;

/**
 * Especially for handling those frobulator needs.
 */
@Controller
public class FrobulatorController {

    private final WebFacade webFacade;

    public FrobulatorController(Optional<WebFacade> adapter) {

        this.webFacade = adapter.orElseGet(WebFacade::empty);
    }

    @GetMapping("/frobulators")
    public String listFrobulators(Model model) {

        return webFacade.listFrobulators(model::addAttribute);
    }

    @GetMapping("/frobulators/new")
    public String newFrobulator(Model model) {

        return webFacade.newFrobulator(model::addAttribute);
    }

    @GetMapping("/frobulators/{key}")
    public String frobulatorDetails(Model model, @PathVariable("key") String key) {

        return webFacade.frobulatorDetails(model::addAttribute, key);
    }

    @GetMapping("/frobulators/{key}/edit")
    public String editFrobulator(Model model, @PathVariable("key") String key) {

        return webFacade.editFrobulator(model::addAttribute, key);
    }

    @DeleteMapping("/frobulators/{key}")
    public String deleteFrobulator(Model model, @PathVariable("key") String key) {

        return webFacade.deleteFrobulator(model::addAttribute, key);
    }

    @PostMapping("/frobulators")
    public String createFrobulator(Model model, //
            @Valid NewFrobulatorForm form, BindingResult errors, RedirectAttributes redirect) {

        return webFacade.createFrobulator(model::addAttribute, form, errors, redirect);
    }
}
