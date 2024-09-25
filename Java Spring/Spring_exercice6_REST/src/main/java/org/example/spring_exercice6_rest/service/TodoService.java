package org.example.spring_exercice6_rest.service;

import org.example.spring_exercice6_rest.entity.Todo;
import org.example.spring_exercice6_rest.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    private final TodoRepository todoRepository;
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> findAll() {
        return (List<Todo>)todoRepository.findAll();
    }

    public Todo save(Todo todo) {
        return todoRepository.save(todo);
    }

    public void delete(Long id) {
        todoRepository.deleteById(id);
    }

    public Todo findById(Long id) {
        return todoRepository.findById(id).orElse(null);
    }

    public List<Todo> findByIsDone(Boolean isDone) {
        List<Todo> todos = (List<Todo>)todoRepository.findAll();
        return todos.stream().filter(t -> t.isDone() == isDone).toList();
    }
}
