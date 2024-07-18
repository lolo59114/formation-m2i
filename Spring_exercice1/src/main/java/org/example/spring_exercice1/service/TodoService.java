package org.example.spring_exercice1.service;

import lombok.Getter;
import org.example.spring_exercice1.model.Todo;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Getter
public class TodoService {
    private List<Todo> todos;

    public TodoService() {
         todos = List.of(
                new Todo(1, "Getter", "Déjà fini", true),
                new Todo(2, "Setter", "A faire", false)
                );
    }

    public Todo getTodo(int id) {
        return todos.stream().filter(todo -> todo.getId() == id).findFirst().orElse(null);
    }
}
