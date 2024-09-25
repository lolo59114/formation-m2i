package org.example.repository;

import org.example.entity.Customer;
import org.example.entity.Sale;
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

    @Override
    public Customer getById (Class<Customer> classe, long id) {
        openSession();
        Query<Customer> query = session.createQuery("select distinct c from Customer c left join fetch c.salesHistory where c.id = :idCustomer", classe);
        query.setParameter("idCustomer", id);
        Customer customer = query.uniqueResultOptional().orElse(null);
        if (customer == null) {
            session.close();
            return null;
        }
        if (customer.getSalesHistory() != null) {
            Query<Sale> query2 = session.createQuery("select distinct s from Sale s left join fetch s.saleLines where s in :sales", Sale.class);
            query2.setParameter("sales", customer.getSalesHistory());
            customer.setSalesHistory(query2.getResultList());
        }
        session.close();
        return customer;
    }
}
