package com.example.ch2labs.labs06;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;

@RestController
public class WordController {
    @PostMapping("/longest-word")
    public ResponseEntity<String> longestWord(@RequestBody Words words) {
        if (words == null || words.getWords().isEmpty()) {
            return ResponseEntity.badRequest().body("Words cannot be empty");
        }

        List<String> longestWords = words.getWords();
        String longestWord = longestWords.stream()
                                        .max(Comparator.comparingInt(String::length))
                                        .orElse("");

        return  ResponseEntity.ok(longestWord);
    }
}
