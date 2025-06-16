package com.example.ch3labs.subtask.controller;

import com.example.ch3labs.subtask.dto.SubtaskCreateRequest;
import com.example.ch3labs.subtask.dto.SubtaskResponse;
import com.example.ch3labs.subtask.service.SubtaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SubtaskController {

    private final SubtaskService subtaskService;

    @PostMapping("/todos/{parentId}/subtasks")
    public ResponseEntity<SubtaskResponse> createSubtask(@PathVariable Long parentId, @RequestBody SubtaskCreateRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(subtaskService.createSubtask(parentId, request));
    }

    @GetMapping("/todos/{parentId}/subtasks")
    public ResponseEntity<List<SubtaskResponse>> findAllSubtasks(@PathVariable Long parentId) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(subtaskService.findAllSubtasks(parentId));
    }

    @PutMapping("/todos/subtasks/{id}")
    public ResponseEntity<SubtaskResponse> updateSubtask(@PathVariable Long id, @RequestBody SubtaskCreateRequest request) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(subtaskService.updateSubtask(id, request));
    }

    @DeleteMapping("/todos/subtasks/{id}")
    public ResponseEntity<?> deleteSubtask(@PathVariable Long id) {
        subtaskService.deleteSubtask(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
