package com.example.ch2labs.labs03;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class RanController {

    @GetMapping("/random")
    public Map<String, Integer> random(@RequestParam Integer min, @RequestParam Integer max) {
        int value = (int)(Math.random() * (max - min + 1)) + min;
        Map<String, Integer> map = new HashMap<>();
        map.put("number", value);
        return map;
    }
}
