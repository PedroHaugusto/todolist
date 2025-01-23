package io.github.pedrohaugusto.springarquitetura.controllers;

import io.github.pedrohaugusto.springarquitetura.models.TodoEntity;
import io.github.pedrohaugusto.springarquitetura.services.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Controller
@RequestMapping("todos")
public class TodoController {

    private final TodoService service;

    public TodoController(TodoService service) {
        this.service = service;
    }

    @PostMapping
    public TodoEntity salvar(@RequestBody TodoEntity todo){
        try{
            return this.service.salvar(todo);
    } catch (IllegalArgumentException e){
        var mensagemErro = e.getMessage();
        throw new ResponseStatusException(HttpStatus.CONFLICT, mensagemErro);
        }
    }

    @PutMapping("/{id}")
    public void atualizarStatus(@PathVariable("id") UUID id, @RequestBody TodoEntity todo){
        todo.setId(id);
        service.atualizarStatus(todo);
    }

    @GetMapping("/{id}")
    public TodoEntity buscarPorId(@PathVariable("id") UUID id){
        return service.buscarPorId(id);
    }
}
