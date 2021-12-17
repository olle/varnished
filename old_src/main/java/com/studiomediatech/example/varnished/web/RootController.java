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

    private final WebFacade webFacade;

    public RootController(Optional<WebFacade> maybe) {

        webFacade = maybe.orElseGet(WebFacade::empty);
    }

    @GetMapping("/")
    public String index(Model model) {

        return webFacade.rootControllerIndexPage(model::addAttribute);
    }
}
