package com.example.ch3labs.subtask.dto;

import com.example.ch3labs.subtask.domain.Subtask;
import lombok.Data;

@Data
public class SubtaskCreateRequest {
    private String title;
    private Boolean completed;

    public static Subtask toDomain() {
        Subtask subtask = new Subtask();
        subtask.setTitle("Subtask Title");
        subtask.setCompleted(false);
        return subtask;
    }
}
