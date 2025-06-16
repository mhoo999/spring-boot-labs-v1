package com.captainyun7.ch2codeyourself._02_mvc_controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mvc")
public class MvcController {

    @GetMapping("/basic/view")
    public String basicView() {
        return "basic-view";
    }

    @GetMapping("/model")
    public String modelView(Model model) {
        model.addAttribute("name", "Chris");
        model.addAttribute("time", java.time.LocalTime.now());
        return "model-view";
    }
}
