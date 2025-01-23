package io.github.pedrohaugusto.springarquitetura.services;

import io.github.pedrohaugusto.springarquitetura.models.TodoEntity;
import io.github.pedrohaugusto.springarquitetura.repositories.TodoRepository;
import io.github.pedrohaugusto.springarquitetura.validators.TodoValidator;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Service
public class TodoService {

    private final TodoRepository repository;
    private final TodoValidator validator;

    public TodoService(TodoRepository todoRepository,
                       TodoValidator validator){
        this.repository = todoRepository;
        this.validator = validator;
    }

    public TodoEntity salvar(TodoEntity novoTodo) {
        validator.validar(novoTodo);
        return repository.save(novoTodo);
    }

    public void atualizarStatus(TodoEntity todo){
        repository.save(todo);
        String status = todo.getConcluido() == Boolean.TRUE ? "Concluido" : "Não Concluido";
    }

    public TodoEntity buscarPorId(UUID id){
        return repository.findById(id).orElse(null);
    }
}
