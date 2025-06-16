package com.example.ch3labs.todo.service;

import com.example.ch3labs.todo.domain.Todo;
import com.example.ch3labs.todo.dto.TodoCreateRequest;
import com.example.ch3labs.todo.dto.TodoResponse;
import com.example.ch3labs.todo.dto.TodoSearchRequest;
import com.example.ch3labs.todo.dto.TodoUpdateRequest;
import com.example.ch3labs.todo.mapper.TodoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoMapper todoMapper;

    public TodoResponse createTodo(TodoCreateRequest request) {
        Todo todo = request.toDomain();
        todoMapper.save(todo);
        return TodoResponse.from(todo);
    }

    public List<TodoResponse> findAllTodo() {
        return todoMapper.findAll().stream()
                .map(todo -> TodoResponse.from(todo))
                .toList();
    }

    public TodoResponse updateTodo(Long id, TodoUpdateRequest request) {
        Todo todo = todoMapper.findById(id);
        todo.setTitle(request.getTitle());
        todo.setCompleted(request.getCompleted());
        todoMapper.update(todo);
        return TodoResponse.from(todo);
    }

    public void deleteTodo(Long id) {
        todoMapper.delete(id);
    }

    public List<TodoResponse> searchByTitle(TodoSearchRequest request) {
        return todoMapper.search(request).stream()
                .map(todo -> TodoResponse.from(todo))
                .toList();
    }
}
