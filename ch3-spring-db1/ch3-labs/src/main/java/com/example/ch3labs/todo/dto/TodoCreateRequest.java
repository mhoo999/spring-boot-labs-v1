package com.example.ch3labs.todo.dto;

import com.example.ch3labs.todo.domain.Todo;
import lombok.Data;

@Data
public class TodoCreateRequest {
    private String title;
    private Boolean completed;

    public Todo toDomain() {
        Todo todo = new Todo();
        todo.setTitle(title);
        todo.setCompleted(completed);
        return todo;
    }
}
