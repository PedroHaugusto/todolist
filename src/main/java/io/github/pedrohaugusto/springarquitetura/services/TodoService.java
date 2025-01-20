package io.github.pedrohaugusto.springarquitetura.services;

import io.github.pedrohaugusto.springarquitetura.models.TodoEntity;
import io.github.pedrohaugusto.springarquitetura.repositories.TodoRepository;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    private TodoRepository repository;

    public TodoService(TodoRepository todoRepository){
        this.repository = todoRepository;
    }

    public TodoEntity salvar(TodoEntity novoTodo) {
        return repository.save(novoTodo);
    }
}
