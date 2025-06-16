package com.example.ch2labs.labs05;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;

@RestController
public class SumController {
    @GetMapping("/sum-digits")
    public ResponseEntity<String> sum(@RequestParam String number) {
        if (number == null) {
            return ResponseEntity.badRequest()
                    .body("Please enter a number");
        }

        int num;

        try {
            num = Integer.parseInt(number);
        } catch (NumberFormatException e) {
            return ResponseEntity.unprocessableEntity()
                    .body("Invalid number");
        }

        if (num < 0 ) {
            return  ResponseEntity.badRequest()
                    .body("Invalid number");
        }

        int sum = Arrays.stream(number.split(""))
                .mapToInt(Integer::parseInt)
                .sum();

        return ResponseEntity.ok().body(sum + "");
    }
}
