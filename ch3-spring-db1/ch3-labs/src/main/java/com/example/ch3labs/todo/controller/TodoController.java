package com.example.ch3labs.todo.controller;

import com.example.ch3labs.todo.dto.TodoCreateRequest;
import com.example.ch3labs.todo.dto.TodoResponse;
import com.example.ch3labs.todo.dto.TodoSearchRequest;
import com.example.ch3labs.todo.dto.TodoUpdateRequest;
import com.example.ch3labs.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @PostMapping
    public ResponseEntity<TodoResponse> createTodo(@RequestBody TodoCreateRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(todoService.createTodo(request));
    }

//    @GetMapping
//    public ResponseEntity<List<TodoResponse>> findAllTodo() {
//        return ResponseEntity.status(HttpStatus.OK)
//                .body(todoService.findAllTodo());
//    }

    @GetMapping
    public ResponseEntity<List<TodoResponse>> searchByTitle(TodoSearchRequest request) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(todoService.searchByTitle(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TodoResponse> updateTodo(@PathVariable Long id, @RequestBody TodoUpdateRequest request) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(todoService.updateTodo(id, request));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
