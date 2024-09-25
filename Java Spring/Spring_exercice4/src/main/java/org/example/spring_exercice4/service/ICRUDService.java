package org.example.spring_exercice4.service;

import java.util.List;

public interface ICRUDService<T> {
    void create(T t);
    void update(T t);
    void delete(T t);
    T getById(Long id);
    List<T> getAll();
}
