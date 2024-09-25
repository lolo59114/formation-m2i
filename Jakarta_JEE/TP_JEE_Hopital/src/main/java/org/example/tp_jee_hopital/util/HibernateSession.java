package org.example.tp_jee_hopital.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public enum HibernateSession {
    INSTANCE;
    private final StandardServiceRegistry registry;
    private final SessionFactory sessionFactory;
    
    HibernateSession() {
        registry = new StandardServiceRegistryBuilder().configure().build();
        sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }

    public static HibernateSession getInstance() {
        return INSTANCE;
    }

    public SessionFactory getSessionFactory (){
        return sessionFactory;
    }
}
