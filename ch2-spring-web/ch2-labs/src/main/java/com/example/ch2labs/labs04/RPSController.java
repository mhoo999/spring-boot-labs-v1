package com.example.ch2labs.labs04;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class RPSController {
    @GetMapping("/rps")
    public Map<String, String> rps(@RequestParam String user) {
        RPS choice = RPS.valueOf(user.toUpperCase());
        RPS server = RPS.values()[(int)(Math.random() * 3)];
        String result = "";

        if (choice.equals(server)) { result = "Draw"; }
        else {
            if (choice.equals(RPS.ROCK)) {
                if (server.equals(RPS.SCISSORS)) { result = "You Win!"; }
                else { result = "You Lose!"; }
            } else if (choice.equals(RPS.SCISSORS)) {
                if (server.equals(RPS.PAPER)) { result = "You Win!"; }
                else { result = "You Lose!"; }
            } else if (choice.equals(RPS.PAPER)) {
                if (server.equals(RPS.ROCK)) { result = "You Win!"; }
                else { result = "You Lose!"; }
            }
        }

        Map<String, String> map = new LinkedHashMap<>(); // 순서 보장

        map.put("user", choice.name().toLowerCase());
        map.put("server", server.name().toLowerCase());
        map.put("result", result);

        return map;
    }
}
