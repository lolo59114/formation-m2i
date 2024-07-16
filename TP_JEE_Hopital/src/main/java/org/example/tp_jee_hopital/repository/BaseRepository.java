package org.example.tp_jee_hopital.repository;

import org.hibernate.Session;

import java.util.List;

public abstract class BaseRepository<T> {
    protected Session _session;
    public BaseRepository(Session session){
        _session = session;
    }

    public void create(T o){_session.persist(o);}

    public void update(T o){
        _session.merge(o);
    }

    public void delete(T o){
        _session.remove(o);
    }

    public T findById(Class<T> classe, long id){ return _session.get(classe, id);}

    public abstract List<T> findAll();
}
