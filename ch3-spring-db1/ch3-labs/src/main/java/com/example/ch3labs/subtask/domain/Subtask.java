package com.example.ch3labs.subtask.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Subtask {
    private Long id;
    private String title;
    private Boolean completed;
    private Long parentId;
}
