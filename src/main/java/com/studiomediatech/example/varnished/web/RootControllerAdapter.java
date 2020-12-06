package com.studiomediatech.example.varnished.web;

import org.springframework.ui.Model;


/**
 * An adapter ensures that we can have some sort of default testable behaviour - be it a novelty one - and still allow
 * some connection-code to inject and set up the proper components for the right runtime profile. This is ENTERPRISE!
 */
public interface RootControllerAdapter {


    default String index(Model model) {

        model.addAttribute("name", "Lloyd");

        return "index";
    }


    default String frobulatorDetails(Model model, String key) {

        return "frobulator/details";
    }


    static RootControllerAdapter instance() {

        return new RootControllerAdapter() {

            // OK
        };
    }
}
