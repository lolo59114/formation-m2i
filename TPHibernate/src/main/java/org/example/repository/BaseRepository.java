package org.example.repository;

import org.example.util.SessionFactorySingleton;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public abstract class BaseRepository<T> {
    private SessionFactory sessionFactory;
    protected Session session;

    public BaseRepository() {
        sessionFactory = SessionFactorySingleton.getSessionFactory();
    }

    public boolean save(T entity) {
        boolean success = false;
        try {
            openSession();
            session.beginTransaction();
            session.persist(entity);
            session.getTransaction().commit();
            success = true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
        return success;
    }

    public boolean update(T entity) {
        boolean success = false;
        try {
            openSession();
            session.beginTransaction();
            session.merge(entity);
            session.getTransaction().commit();
            success = true;
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return success;
    }


    public boolean delete(T entity) {
        boolean success = false;
        try {
            openSession();
            session.beginTransaction();
            session.remove(entity);
            session.getTransaction().commit();
            success = true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
        return success;
    }

    public T getById (Class<T> classe, long id){
        openSession();
        T result = (T) session.get(classe, id);
        session.close();
        return result;
    }


    protected void openSession() {
        session = sessionFactory.openSession();
    }

}
