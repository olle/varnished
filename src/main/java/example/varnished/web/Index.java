package example.varnished.web;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class Index {

    @GetMapping("/")
    public String showIndexPage() {

        return "index";
    }
}
