package com.example.ch3labs.subtask.dto;

import com.example.ch3labs.subtask.domain.Subtask;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SubtaskResponse {
    private Long id;
    private String title;
    private Boolean completed;
    private Long parentId;

    public static SubtaskResponse from(Subtask subtask) {
        return  new SubtaskResponse(
                subtask.getId(),
                subtask.getTitle(),
                subtask.getCompleted(),
                subtask.getParentId()
        );
    }
}
