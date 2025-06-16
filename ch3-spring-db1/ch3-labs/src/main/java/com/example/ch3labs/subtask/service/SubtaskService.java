package com.example.ch3labs.subtask.service;

import com.example.ch3labs.subtask.domain.Subtask;
import com.example.ch3labs.subtask.dto.SubtaskCreateRequest;
import com.example.ch3labs.subtask.dto.SubtaskResponse;
import com.example.ch3labs.subtask.mapper.SubtaskMapper;
import com.example.ch3labs.todo.mapper.TodoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubtaskService {

    private final TodoMapper todoMapper;
    private final SubtaskMapper subtaskMapper;

    public SubtaskResponse createSubtask(Long parentId, SubtaskCreateRequest request) {
        if (todoMapper.findById(parentId) == null) {
            throw new IllegalArgumentException("Parent id not found");
        }

        Subtask subtask = SubtaskCreateRequest.toDomain();
        subtask.setParentId(parentId);
        subtaskMapper.save(subtask);
        return SubtaskResponse.from(subtask);
    }

    public List<SubtaskResponse> findAllSubtasks(Long parentId) {
        if (todoMapper.findById(parentId) == null) {
            throw new IllegalArgumentException("Parent id not found");
        }

        return subtaskMapper.findByParentId(parentId).stream()
                .map(subtask -> SubtaskResponse.from(subtask))
                .toList();
    }

    public SubtaskResponse updateSubtask(Long id, SubtaskCreateRequest request) {
        Subtask subtask = subtaskMapper.findById(id);
        subtask.setTitle(request.getTitle());
        subtask.setCompleted(request.getCompleted());
        subtaskMapper.update(subtask);
        return SubtaskResponse.from(subtask);
    }

    public void deleteSubtask(Long id) {
        subtaskMapper.delete(id);
    }
}
