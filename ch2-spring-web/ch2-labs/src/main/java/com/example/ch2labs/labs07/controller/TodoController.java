package com.example.ch2labs.labs07.controller;

import com.example.ch2labs.labs07.dto.TodoRequest;
import com.example.ch2labs.labs07.dto.TodoResponse;
import com.example.ch2labs.labs07.service.TodoService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/todos")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @PostMapping()
    public ResponseEntity<TodoResponse> createTodo(@RequestBody TodoRequest todoRequest) {
        TodoResponse response = todoService.createTodo(todoRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<TodoResponse>> getTodos() {
        List<TodoResponse> responses = todoService.getTodos();
        if (responses == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TodoResponse> updateTodo(@PathVariable String id, @RequestBody TodoRequest todoRequest) {
        TodoResponse response = todoService.updateTodo(id, todoRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteTodo(@PathVariable String id) {
        todoService.deleteTodo(id);
        return new  ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
