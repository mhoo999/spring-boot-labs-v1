package com.example.ch2labs.labs07.service;

import com.example.ch2labs.labs07.domain.Todo;
import com.example.ch2labs.labs07.dto.TodoRequest;
import com.example.ch2labs.labs07.dto.TodoResponse;
import com.example.ch2labs.labs07.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoResponse createTodo(TodoRequest todoRequest) {
        Todo todo = todoRepository.save(new Todo(todoRequest.getTitle()));

        return new TodoResponse(
                todo.getId(),
                todo.getTitle(),
                todo.getCompleted()
        );
    }

    public List<TodoResponse> getTodos() {
        List<Todo> todos = todoRepository.findAll();

        return todos.stream()
                .map(Todo -> new TodoResponse(Todo.getId(), Todo.getTitle(), Todo.getCompleted()))
                .collect(Collectors.toList());
    }

    public TodoResponse updateTodo(String id, TodoRequest todoRequest) {
        if (todoRequest.getTitle().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Title cannot be empty");
        }

        Todo todo = todoRepository.findById(Long.parseLong(id));
        if (todo == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        Todo newTodo = todoRepository.update(Long.parseLong(id), todo);

        return new TodoResponse(
                newTodo.getId(),
                newTodo.getTitle(),
                newTodo.getCompleted()
        );
    }

    public void deleteTodo(String id) {
        Todo todo = todoRepository.findById(Long.parseLong(id));
        if (todo == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        todoRepository.delete(todo.getId());
    }
}
