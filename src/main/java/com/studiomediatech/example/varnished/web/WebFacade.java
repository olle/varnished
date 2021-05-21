package com.studiomediatech.example.varnished.web;

import java.util.function.BiConsumer;

import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.studiomediatech.example.varnished.web.frobulator.FrobulatorControllerAdapter;
import com.studiomediatech.example.varnished.web.frobulator.NewFrobulatorForm;

public class WebFacade {

    private final FrobulatorControllerAdapter frobulatorControllerAdapter;

    public WebFacade(FrobulatorControllerAdapter frobulatorControllerAdapter) {

        this.frobulatorControllerAdapter = frobulatorControllerAdapter;
    }

    public String listFrobulators(BiConsumer<String, Object> sink) {
        return frobulatorControllerAdapter.listFrobulators(sink);
    }

    public String frobulatorDetails(BiConsumer<String, Object> sink, String key) {
        return frobulatorControllerAdapter.frobulatorDetails(sink, key);
    }

    public String editFrobulator(BiConsumer<String, Object> sink, String key) {
        return frobulatorControllerAdapter.editFrobulator(sink, key);
    }

    public String deleteFrobulator(BiConsumer<String, Object> sink, String key) {
        return frobulatorControllerAdapter.deleteFrobulator(sink, key);
    }

    public String newFrobulator(BiConsumer<String, Object> sink) {
        return frobulatorControllerAdapter.newFrobulator(sink);
    }

    public String createFrobulator(BiConsumer<String, Object> sink, NewFrobulatorForm form, BindingResult errors,
            RedirectAttributes redirect) {
        return frobulatorControllerAdapter.createFrobulator(sink, form, errors, redirect);
    }

    public String rootControllerIndexPage(BiConsumer<String, Object> sink) {

        sink.accept("name", "Lloyd");

        return "index";
    }

    static WebFacade empty() {

        return new WebFacade(FrobulatorControllerAdapter.instance());
    }

}
