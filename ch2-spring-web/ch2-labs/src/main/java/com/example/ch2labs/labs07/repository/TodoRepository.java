package com.example.ch2labs.labs07.repository;

import com.example.ch2labs.labs07.domain.Todo;
import com.example.ch2labs.labs07.dto.TodoRequest;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class TodoRepository {

    private final Map<Long, Todo> store =  new HashMap<>();
    private Long sequence = 0L;

    // todo 추가하고 생성된 번호 반환
    public Todo save (Todo todo) {
        todo.setId(sequence);
        store.put(sequence++, todo);
        return todo;
    }

    public Todo findById(Long id) {
        return store.get(id);
    }

    public List<Todo> findAll() {
        return new ArrayList<>(store.values());
    }

    public Todo update(Long id, Todo todo) {
        return store.put(id, todo);
    }

    public void delete(Long id) {
        store.remove(id);
    }


}
