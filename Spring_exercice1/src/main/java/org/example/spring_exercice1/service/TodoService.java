package org.example.spring_exercice1.service;

import org.example.spring_exercice1.model.Todo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    List<Todo> todos;

    public TodoService() {
         todos = List.of(
                new Todo(1, "Getter", "Déjà fini", true),
                new Todo(2, "Setter", "A faire", false)
                );
    }

    public List<Todo> getTodos() {
        return todos;
    }

    public Todo getTodo(int id) {
        return todos.stream().filter(todo -> todo.getId() == id).findFirst().orElse(null);
    }
}
