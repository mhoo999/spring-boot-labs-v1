package com.example.ch3labs.todo.dto;

import lombok.Data;

@Data
public class TodoSearchRequest {
    private String keyword = "";
    private int page = 1;
    private int size = 10;

    public int getOffset() {
        return (page - 1) * size;
    }
}
