package example.varnished.web;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;


@Controller
public class Index {

    private final IndexWebAdapter adapter;

    public Index(Optional<IndexWebAdapter> adapter) {

        this.adapter = adapter.orElseGet(IndexWebAdapter::empty);
    }

    @GetMapping(path = "/")
    public String showIndexPage(Model model) {

        model.addAttribute("greeting", adapter.fetchGreeting());

        return "index";
    }
}

interface IndexWebAdapter {

    static IndexWebAdapter empty() {

        return new IndexWebAdapter() {

            // OK
        };
    }


    default String fetchGreeting() {

        return "World";
    }
}
