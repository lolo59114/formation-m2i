package org.example.exercicesJPA.exercice2Billeterie.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;
import org.example.exercicesJPA.exercice2Billeterie.Entity.Address;

import java.util.HashSet;
import java.util.Set;

public class AddressRepository {
    EntityManagerFactory emf;
    EntityManager em;

    public AddressRepository(EntityManagerFactory emf) {
        this.emf = emf;
        em = emf.createEntityManager();
    }

    // Check connection state
    private EntityManager getEntityManager() {
        if (em == null || !em.isOpen())
            this.em = emf.createEntityManager();
        return em;
    }

    public void createAddress(Address address) {
        this.em = getEntityManager();
        this.em.getTransaction().begin();
        try{
            this.em.persist(address);
            this.em.getTransaction().commit();
        } catch (Exception e) {
            this.em.getTransaction().rollback();
        }
    }

    public Address getAddressById(int id) {
        this.em = getEntityManager();
        return this.em.find(Address.class, id);
    }

    public Set<Address> getAllAddress() {
        this.em = getEntityManager();
        TypedQuery<Address> query = em.createQuery("SELECT a FROM Address a", Address.class);
        return new HashSet<Address>(query.getResultList());
    }

    public boolean updateAddress(Address address) {
        boolean result = false;
        this.em = getEntityManager();
        this.em.getTransaction().begin();
        try {
            if(this.em.find(Address.class, address.getId()) != null) {
                this.em.persist(address);
                this.em.getTransaction().commit();
                result = true;
            }
        } catch (Exception e) {
            this.em.getTransaction().rollback();
        }
        return result;
    }

    public boolean deleteAddress(Address address) {
        this.em = getEntityManager();
        this.em.getTransaction().begin();
        try{
            if(this.em.find(Address.class, address.getId()) != null) {
                this.em.remove(address);
                this.em.getTransaction().commit();
                return true;
            }
        } catch (Exception e) {
            this.em.getTransaction().rollback();
        }
        return false;
    }
}
