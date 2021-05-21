package com.studiomediatech.example.varnished.web.frobulator;

import java.util.function.BiConsumer;

import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public interface FrobulatorControllerAdapter {

    default String listFrobulators(BiConsumer<String, Object> sink) {

        return "frobulators/list";
    }

    default String frobulatorDetails(BiConsumer<String, Object> sink, String key) {

        return "frobulators/details";
    }

    default String editFrobulator(BiConsumer<String, Object> sink, String key) {

        return "redirect:/frobulators";
    }

    default String deleteFrobulator(BiConsumer<String, Object> sink, String key) {

        return "redirect:/frobulators";
    }

    default String newFrobulator(BiConsumer<String, Object> sink) {

        return "frobulators/new";
    }

    default String createFrobulator(BiConsumer<String, Object> sink, NewFrobulatorForm form, BindingResult errors,
            RedirectAttributes redirect) {

        return "redirect:/frobulators";
    }

    static FrobulatorControllerAdapter instance() {

        return new FrobulatorControllerAdapter() {

            // OK
        };
    }
}
