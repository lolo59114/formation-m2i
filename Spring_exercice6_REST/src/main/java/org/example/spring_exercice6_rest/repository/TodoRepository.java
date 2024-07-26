package org.example.spring_exercice6_rest.repository;

import org.example.spring_exercice6_rest.entity.Todo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TodoRepository extends CrudRepository<Todo, Long> {
}
