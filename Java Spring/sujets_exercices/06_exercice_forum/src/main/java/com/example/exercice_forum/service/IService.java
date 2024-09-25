package com.example.exercice_forum.service;

import java.util.List;

public interface IService<T> {
    public List<T> getAll();
    public T getById(Long id);
    public T add(T element);
    public void delete(Long id);
    public T update(T element);
}
