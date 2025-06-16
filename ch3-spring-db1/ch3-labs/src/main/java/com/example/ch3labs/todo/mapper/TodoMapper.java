package com.example.ch3labs.todo.mapper;

import com.example.ch3labs.todo.domain.Todo;
import com.example.ch3labs.todo.dto.TodoSearchRequest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TodoMapper {
    void save(Todo todo);
    List<Todo> findAll();
    void update(Todo todo);
    void delete(Long id);
    Todo findById(Long id);
    List<Todo> search(TodoSearchRequest request);
}
