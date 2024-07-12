package org.example.exercice5.repository;

import org.example.exercice5.model.Dog;
import org.example.exercice5.util.SessionFactorySingleton;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class DogRepository {
    private SessionFactory sessionFactory;
    private Session session;
    public DogRepository() {
        sessionFactory = SessionFactorySingleton.getSessionFactory();
    }

    public boolean save(Dog dog) {
        boolean success = false;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.persist(dog);
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

    public List<Dog> getAll(){
        session = sessionFactory.openSession();
        Query<Dog> query = session.createQuery("from Dog", Dog.class);
        List<Dog> dogs = query.list();
        session.close();
        return dogs;
    }

    public Dog getById(int id){
        session = sessionFactory.openSession();
        Dog dog = session.get(Dog.class, id);
        session.close();
        return dog;
    }


}
