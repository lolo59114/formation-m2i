package org.example.spring_exercice6_rest.controller;

import org.example.spring_exercice6_rest.entity.Todo;
import org.example.spring_exercice6_rest.service.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<Todo>> getAll() {
        return ResponseEntity.ok(todoService.findAll());
    }

    @PostMapping("/add")
    public ResponseEntity<Todo> add(@RequestBody Todo todo) {
        return ResponseEntity.ok(todoService.save(todo));
    }

    @PutMapping("/update")
    public ResponseEntity<Todo> update(@RequestBody Todo todo) {
        return ResponseEntity.ok(todoService.save(todo));
    }

    @DeleteMapping("/delete")
    public ResponseEntity delete(@RequestParam("id") Long id) {
        todoService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> getById(@PathVariable("id") long id) {
        Todo todo = todoService.findById(id);
        if (todo == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(todo);
    }

    @GetMapping("/done")
    public ResponseEntity<List<Todo>> getByDone(@RequestParam("done") boolean done) {
        return ResponseEntity.ok(todoService.findByIsDone(done));
    }
}
