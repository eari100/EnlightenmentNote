package com.example.enlightenmentNote.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/detail/{postSeq}")
    public String detail(@PathVariable String postSeq, Model model) {
        model.addAttribute("postSeq", postSeq);

        return "detail";
    }

    @GetMapping("/write")
    public String write(Model model,
                        @RequestParam(defaultValue = "write") String mode,
                        @RequestParam(required = false, defaultValue = "") String postSeq) {
        model.addAttribute("mode", mode);
        model.addAttribute("postSeq", postSeq);

        return "write";
    }
}
