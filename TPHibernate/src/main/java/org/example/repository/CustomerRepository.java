package org.example.repository;

import org.example.entity.Customer;
import org.hibernate.query.Query;

import java.util.List;

public class CustomerRepository extends BaseRepository<Customer> {

    public List<Customer> getAll() {
        openSession();
        Query<Customer> query = session.createQuery("from Customer c", Customer.class);
        List<Customer> customers = query.list();
        session.close();
        return customers;
    }
}
