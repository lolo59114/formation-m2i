package org.example.exercicesJPA.exercice1Zoo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.ArrayList;
import java.util.List;

public class AnimalDAO {
    EntityManagerFactory emf;
    EntityManager em = null;
    public AnimalDAO() {
        this.emf = Persistence.createEntityManagerFactory("jpa");
    }

    private EntityManager getEntityManager() {
        if (em == null || !em.isOpen()) {
            em = emf.createEntityManager();
        }
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
        } finally {
            this.em.close();
        }
    }

    public Animal getAnimal(int id) {
        this.em = getEntityManager();
        return this.em.find(Animal.class, id);
    }

    public List<Animal> getAnimalsByName(String name) {
        this.em = getEntityManager();
        List<Animal> animals = new ArrayList<Animal>();
        Query query = this.em.createQuery("SELECT a FROM Animal a WHERE a.nom = :name", Animal.class);
        query.setParameter("name", name);
        animals = query.getResultList();
        this.em.close();
        return animals;
    }

    public List<Animal> getAnimalsByRegime(EnumRegimeAlim regime) {
        this.em = getEntityManager();
        List<Animal> animals = new ArrayList<>();
        Query query = this.em.createQuery("SELECT a FROM Animal a WHERE a.regimeAlim = :regime", Animal.class);
        query.setParameter("regime", regime);
        animals = query.getResultList();
        this.em.close();
        return animals;
    }
}
