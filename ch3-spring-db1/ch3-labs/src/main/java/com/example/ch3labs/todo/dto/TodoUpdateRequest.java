package com.example.ch3labs.todo.dto;

import lombok.Data;

@Data
public class TodoUpdateRequest {
    private String title;
    private Boolean completed;
}
