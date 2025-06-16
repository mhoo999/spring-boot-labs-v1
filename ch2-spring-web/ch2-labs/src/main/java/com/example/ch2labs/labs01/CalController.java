package com.example.ch2labs.labs01;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cal")
public class CalController {

    @GetMapping("/add")
    public String add(@RequestParam Integer a, @RequestParam Integer b) {
        String s = String.valueOf((a + b));
        return "결과: " + a + " + " + b + " = " + s;
    }

    @GetMapping("/sub")
    public String sub(@RequestParam Integer a, @RequestParam Integer b) {
        String s = String.valueOf((a - b));
        return "결과: " + a + " - " + b + " = " + s;
    }

    @GetMapping("/mul")
    public String mul(@RequestParam Integer a, @RequestParam Integer b) {
        String s = String.valueOf((a * b));
        return "결과: " + a + " * " + b + " = " + s;
    }

    @GetMapping("/div")
    public String div(@RequestParam Integer a, @RequestParam Integer b) {
        String s = String.valueOf((a / b));
        return "결과: " + a + " / " + b + " = " + s;
    }
}
