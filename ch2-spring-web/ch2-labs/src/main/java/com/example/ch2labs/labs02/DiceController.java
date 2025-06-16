package com.example.ch2labs.labs02;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class DiceController {
    @GetMapping("/dice")
    public Map<String, Integer> dice() {
        int value = (int)(Math.random() * 6) + 1;
        Map<String, Integer> map = new HashMap<>();
        map.put("number", value);
        return map;
    }
}
