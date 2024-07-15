package org.example.exercice5.service;

import org.example.exercice5.model.Dog;
import org.example.exercice5.repository.DogRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.time.LocalDate;
import java.util.List;

public class DogService {
    private DogRepository dogRepository;
    private SessionFactory _sessionFactory;
    private Session session;

    public DogService(SessionFactory sessionFactory) {
        _sessionFactory = sessionFactory;
    }

    public List<Dog> getAll() {
        session = _sessionFactory.openSession();
        dogRepository = new DogRepository(session);
        List<Dog> dogs = dogRepository.getAll();
        session.close();
        return dogs;
    }

    public boolean save(String name, String breed, LocalDate birthDate) {
        boolean success = false;
        session = _sessionFactory.openSession();
        session.beginTransaction();
        dogRepository = new DogRepository(session);
        Dog dog = new Dog(name, breed, birthDate);
        try {
            dogRepository.save(dog);
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

    public Dog getById(int id) {
        session = _sessionFactory.openSession();
        dogRepository = new DogRepository(session);
        Dog dog = dogRepository.getById(id);
        session.close();
        return dog;
    }

    public boolean delete(Dog dog) {
        boolean success = false;
        session = _sessionFactory.openSession();
        dogRepository = new DogRepository(session);
        try {
            dogRepository.delete(dog);
            success = true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
        return success;
    }
}
