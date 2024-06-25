package org.example.exercicesJPA;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Computer computer = new Computer("131222", LocalDate.now());
        em.persist(computer);
        em.getTransaction().commit();
    }
}
