package org.example.service;

import org.example.entity.Customer;
import org.example.repository.CustomerRepository;

import java.util.List;

public class CustomerService implements BaseService<Customer>{
    CustomerRepository customerRepository;

    public CustomerService() {
        customerRepository = new CustomerRepository();
    }

    @Override
    public boolean delete(long id) {
        Customer customer = customerRepository.getById(Customer.class, id);
        if(customer == null) {
            System.out.println("Le client avec id " + id + " n'a pas été trouvé");
            return false;
        }

        return customerRepository.delete(customer);
    }

    @Override
    public Customer findById(long id) {
        return customerRepository.getById(Customer.class, id);
    }

    @Override
    public List<Customer> getAll() {
        return customerRepository.getAll();
    }

    @Override
    public boolean update(Customer customer) {
        return customerRepository.update(customer);
    }

    public boolean create(String name, String email) {
        Customer customer = Customer.builder()
                .name(name)
                .email(email)
                .build();
        return customerRepository.save(customer);
    }
}
