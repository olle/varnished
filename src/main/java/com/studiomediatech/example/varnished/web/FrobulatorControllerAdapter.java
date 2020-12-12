package com.studiomediatech.example.varnished.web;

import com.studiomediatech.example.varnished.web.frobulator.FrobulatorForm;

import org.springframework.ui.Model;

import org.springframework.validation.BindingResult;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;


public interface FrobulatorControllerAdapter {


    default String listFrobulators(Model model) {

        return "frobulators/list";
    }


    default String frobulatorDetails(Model model, String key) {

        return "frobulators/details";
    }


    default String deleteFrobulator(Model model, String key) {

        return "redirect:/";
    }


    default String newFrobulator(Model model) {

        return "frobulators/new";
    }


    default String createFrobulator(Model model, FrobulatorForm form, BindingResult errors,
        RedirectAttributes redirect) {

        return "redirect:/";
    }


    static FrobulatorControllerAdapter instance() {

        return new FrobulatorControllerAdapter() {

            // OK
        };
    }
}
