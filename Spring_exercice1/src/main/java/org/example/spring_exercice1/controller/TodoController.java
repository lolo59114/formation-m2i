package org.example.spring_exercice1.controller;

import org.example.spring_exercice1.model.Todo;
import org.example.spring_exercice1.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @RequestMapping("/")
    public String todoList(Model model) {
        List<Todo> todos = todoService.getTodos();
        model.addAttribute("todos", todos);
        return "index";
    }

    @RequestMapping("/{id}")
    public String todoDetail(@PathVariable int id, Model model) {
        Todo todo = todoService.getTodo(id);
        model.addAttribute("todo", todo);
        return "details";
    }

    @RequestMapping("/json")
    @ResponseBody
    public List<Todo> todoJson() {
        return todoService.getTodos();
    }

}
