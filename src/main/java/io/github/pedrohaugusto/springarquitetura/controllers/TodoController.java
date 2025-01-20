package io.github.pedrohaugusto.springarquitetura.controllers;

import io.github.pedrohaugusto.springarquitetura.models.TodoEntity;
import io.github.pedrohaugusto.springarquitetura.services.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("todos")
public class TodoController {

    private TodoService service;

    public TodoController(TodoService service) {
        this.service = service;
    }

    @PostMapping
    public TodoEntity salvar(@RequestBody TodoEntity todo){
        return this.service.salvar(todo);
    }
}
