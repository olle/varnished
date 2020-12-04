package com.studiomediatech.example.varnished.web;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;


/**
 * Serving those hungry hungry hippos!
 */
@Controller
public class RootController {

    @GetMapping("/")
    public String index(Model model) {

        model.addAttribute("name", "Lloyd");

        return "index";
    }
}
