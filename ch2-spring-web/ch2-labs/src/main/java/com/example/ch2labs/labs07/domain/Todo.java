package com.example.ch2labs.labs07.domain;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Todo {
    private Long id;
    private String title;
    private Boolean completed;

    public Todo(String title) {
        this.title = title;
        this.completed = false;
    }
}
