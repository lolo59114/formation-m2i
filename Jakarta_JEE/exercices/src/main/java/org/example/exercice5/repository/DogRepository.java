package org.example.exercice5.repository;

import org.example.exercice5.model.Dog;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class DogRepository {
    private Session _session;
    public DogRepository(Session session) {
        _session = session;
    }

    public void save(Dog dog) {
        _session.persist(dog);
    }

    public List<Dog> getAll(){
        Query<Dog> query = _session.createQuery("from Dog", Dog.class);
        List<Dog> dogs = query.list();
        return dogs;
    }

    public Dog getById(int id){
        Dog dog = _session.get(Dog.class, id);
        return dog;
    }

    public boolean delete(Dog dog) {
        boolean success = false;
        try {
            _session.remove(dog);
            success = true;
        } catch (Exception e) {
            _session.getTransaction().rollback();
            System.out.println(e.getMessage());
        } finally {
            _session.close();
        }
        return success;
    }

}
