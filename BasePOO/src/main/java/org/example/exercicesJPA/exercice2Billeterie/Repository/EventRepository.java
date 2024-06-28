package org.example.exercicesJPA.exercice2Billeterie.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.example.exercicesJPA.exercice2Billeterie.Entity.Event;

import java.util.List;


public class EventRepository {
    EntityManagerFactory emf;
    EntityManager em;
    public EventRepository(EntityManagerFactory emf) {
        this.emf = emf;
        em = emf.createEntityManager();
    }

    // Check connection state
    private EntityManager getEntityManager() {
        if (em == null || !em.isOpen())
            this.em = emf.createEntityManager();
        return em;
    }

    public void createEvent(Event event) {
        this.em = getEntityManager();
        this.em.getTransaction().begin();
        try{
            this.em.persist(event);
            this.em.getTransaction().commit();
        } catch (Exception e) {
            this.em.getTransaction().rollback();
        }
    }

    public Event getEventById(int id) {
        this.em = getEntityManager();
        return this.em.find(Event.class, id);
    }

    public List<Event> getAllEvents() {
        this.em = getEntityManager();
        return this.em.createQuery("from Event", Event.class).getResultList();
    }

    public boolean updateEvent(Event event) {
        this.em = getEntityManager();
        try {
            this.em.getTransaction().begin();
            if (this.em.find(Event.class, event.getId()) != null) {
                this.em.persist(event);
                this.em.getTransaction().commit();
                return true;
            }
        } catch (Exception e) {
            this.em.getTransaction().rollback();
        }
        return false;
    }

    public boolean deleteEvent(Event event) {
        this.em = getEntityManager();
        try {
            this.em.getTransaction().begin();
            this.em.remove(event);
            this.em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            this.em.getTransaction().rollback();
        }
        return false;
    }
}
