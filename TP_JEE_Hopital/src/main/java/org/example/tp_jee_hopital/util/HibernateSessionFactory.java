package org.example.tp_jee_hopital.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateSessionFactory {
        private static StandardServiceRegistry registry;
        private static SessionFactory sessionFactory;

        private HibernateSessionFactory(){}

        public static synchronized SessionFactory getSessionFactory (){
            if(sessionFactory == null){
                registry = new StandardServiceRegistryBuilder().configure().build();
                sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            }
            return sessionFactory;
        }

}
