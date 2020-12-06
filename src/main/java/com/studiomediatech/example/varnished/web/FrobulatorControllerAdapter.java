package com.studiomediatech.example.varnished.web;

import org.springframework.ui.Model;


public interface FrobulatorControllerAdapter {


    default String frobulatorDetails(Model model, String key) {

        return "frobulators/details";
    }


    static FrobulatorControllerAdapter instance() {

        return new FrobulatorControllerAdapter() {

            // OK
        };
    }
}
