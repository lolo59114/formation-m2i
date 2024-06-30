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

    public void save(T element) {
        try {
            openSession();
            session.beginTransaction();
            session.persist(element);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
    }

    public void update(T element) {
        try {
            openSession();
            session.beginTransaction();
            session.merge(element);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }


    public void delete(T element) {
        try {
            openSession();
            session.beginTransaction();
            session.remove(element);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
    }

    public T getById (Class<T> classe, long id){
        openSession();
        return session.get(classe, id);
    }


    protected void openSession() {
        session = sessionFactory.openSession();
    }

}
