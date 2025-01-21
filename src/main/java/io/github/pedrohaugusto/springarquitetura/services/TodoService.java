package io.github.pedrohaugusto.springarquitetura.services;

import io.github.pedrohaugusto.springarquitetura.models.TodoEntity;
import io.github.pedrohaugusto.springarquitetura.repositories.TodoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Service
public class TodoService {

    private TodoRepository repository;

    public TodoService(TodoRepository todoRepository){
        this.repository = todoRepository;
    }

    public TodoEntity salvar(TodoEntity novoTodo) {
        return repository.save(novoTodo);
    }

    public void atualizarStatus(TodoEntity todo){
        repository.save(todo);
    }

    public TodoEntity buscarPorId(UUID id){
        return repository.findById(id).orElse(null);
    }
}
