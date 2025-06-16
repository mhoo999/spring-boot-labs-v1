package com.example.ch2labs.labs06;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Words {
    List<String> words;
    public Words(List<String> words) {
        this.words = words;
    }
}
