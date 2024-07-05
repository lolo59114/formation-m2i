package org.example.service;


import java.util.List;

public interface BaseService<T> {
    public boolean delete (long id);
    public T findById (long id);
    public List<T> getAll ();
}
