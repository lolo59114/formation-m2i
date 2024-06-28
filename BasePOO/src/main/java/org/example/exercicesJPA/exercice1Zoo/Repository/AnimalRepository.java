package org.example.exercicesJPA.exercice1Zoo.Repository;

import jakarta.persistence.*;
import org.example.exercicesJPA.exercice1Zoo.Entity.Animal;
import org.example.exercicesJPA.exercice1Zoo.Util.Diet;

import java.util.ArrayList;
import java.util.List;

public class AnimalRepository {
    EntityManagerFactory emf;
    EntityManager em = null;
    public AnimalRepository() {
        this.emf = Persistence.createEntityManagerFactory("exercice_jpa");
    }

    // Check connection state
    private EntityManager getEntityManager() {
        if (emf == null || !emf.isOpen())
            this.emf = Persistence.createEntityManagerFactory("exercice_jpa");
        if (em == null || !em.isOpen())
            this.em = emf.createEntityManager();
        return em;
    }

    public void createAnimal(Animal animal) {
        this.em = getEntityManager();
        this.em.getTransaction().begin();
        try{
            this.em.persist(animal);
            this.em.getTransaction().commit();
        } catch (Exception e) {
            this.em.getTransaction().rollback();
        }
    }

    public Animal getAnimal(int id) {
        this.em = getEntityManager();
        return this.em.find(Animal.class, id);
    }

    public List<Animal> getAnimalsByName(String name) {
        this.em = getEntityManager();
        List<Animal> animals = new ArrayList<>();
        TypedQuery<Animal> query = this.em.createQuery("SELECT a FROM Animal a WHERE a.name = :name", Animal.class);
        query.setParameter("name", name);
        animals = query.getResultList();
        return animals;
    }

    public List<Animal> getAnimalsByRegime(Diet regime) {
        this.em = getEntityManager();
        List<Animal> animals = new ArrayList<>();
        TypedQuery<Animal> query = this.em.createQuery("SELECT a FROM Animal a WHERE a.regimeAlim = :regime", Animal.class);
        query.setParameter("regime", regime);
        animals = query.getResultList();
        return animals;
    }
}
