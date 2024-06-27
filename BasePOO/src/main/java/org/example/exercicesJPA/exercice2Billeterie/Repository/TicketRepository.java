package org.example.exercicesJPA.exercice2Billeterie.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import org.example.exercicesJPA.exercice2Billeterie.Entity.Ticket;

import java.util.List;

public class TicketRepository {
    EntityManagerFactory emf;
    EntityManager em;

    public TicketRepository(EntityManagerFactory emf) {
        this.emf = emf;
        em = emf.createEntityManager();
    }

    // Check connection state
    private EntityManager getEntityManager() {
        if (em == null || !em.isOpen())
            this.em = emf.createEntityManager();
        return em;
    }

    public void createTicket(Ticket ticket) {
        this.em = getEntityManager();
        Query query = this.em.createQuery("SELECT count(t) FROM Ticket t WHERE t.event.id = :eventId", Integer.class)
                .setParameter("eventId", ticket.getEvent().getId());
        int placeNumber = query.getFirstResult();
        if(placeNumber > ticket.getEvent().getPlaceNumber()) {
            System.out.println("Sorry no more place are available");
        } else {
            ticket.setPlaceNumber(placeNumber);
            this.em.getTransaction().begin();
            try{
                this.em.persist(ticket);
                this.em.getTransaction().commit();
            } catch (Exception e) {
                this.em.getTransaction().rollback();
            }
        }

    }

    public Ticket getTicketById(int id) {
        this.em = getEntityManager();
        return this.em.find(Ticket.class, id);
    }

    public List<Ticket> getAllTickets() {
        this.em = getEntityManager();
        return this.em.createQuery("from Ticket", Ticket.class).getResultList();
    }

    public boolean updateTicket(Ticket ticket) {
        this.em = getEntityManager();
        try {
            this.em.getTransaction().begin();
            if(this.em.find(Ticket.class, ticket.getId()) != null){
                this.em.persist(ticket);
                this.em.getTransaction().commit();
                return true;
            } else {
                System.out.println("Ticket does not exist");
            }
        } catch (Exception e) {
            this.em.getTransaction().rollback();
        }
        return false;
    }

//    public boolean deleteTicket(int id) {
//        boolean result = false;
//        this.em = getEntityManager();
//    }
}
