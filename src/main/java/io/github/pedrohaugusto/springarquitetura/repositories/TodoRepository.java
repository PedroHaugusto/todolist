package io.github.pedrohaugusto.springarquitetura.repositories;

import io.github.pedrohaugusto.springarquitetura.models.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TodoRepository extends JpaRepository<TodoEntity, UUID> {

     boolean existsByDescricao(String descricao);
}
