package org.example.exercicesJPA.exercice2Billeterie.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.example.exercicesJPA.exercice2Billeterie.Entity.Customer;

import java.util.List;

public class CustomerRepository {
    EntityManagerFactory emf;
    EntityManager em;

    public CustomerRepository(EntityManagerFactory emf) {
        this.emf = emf;
        em = emf.createEntityManager();
    }

    // Check connection state
    private EntityManager getEntityManager() {
        if (em == null || !em.isOpen())
            this.em = emf.createEntityManager();
        return em;
    }

    public void createCustomer(Customer customer) {
        this.em = getEntityManager();
        this.em.getTransaction().begin();
        try {
            this.em.persist(customer);
            this.em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            this.em.getTransaction().rollback();
        }
    }

    public Customer getCustomerById(int id) {
        this.em = getEntityManager();
        return em.find(Customer.class, id);
    }

    public List<Customer> getAllCustomers() {
        this.em = getEntityManager();
        return em.createQuery("from Customer c", Customer.class).getResultList();
    }

    public boolean updateCustomer(Customer customer) {
        this.em = getEntityManager();
        try {
            this.em.getTransaction().begin();
            if (this.em.find(Customer.class, customer.getId()) != null) {
                this.em.persist(customer);
                this.em.getTransaction().commit();
                return true;
            }
        } catch (Exception e) {
            this.em.getTransaction().rollback();
        }
        return false;
    }

    public boolean deleteCustomer(Customer customer) {
        this.em = getEntityManager();
        try {
            this.em.getTransaction().begin();
            if (this.em.find(Customer.class, customer.getId()) != null) {
                this.em.remove(customer);
                this.em.getTransaction().commit();
                return true;
            }
        } catch (Exception e) {
            this.em.getTransaction().rollback();
        }

        return false;
    }
}
