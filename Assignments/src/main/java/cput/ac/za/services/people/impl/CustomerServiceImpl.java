package cput.ac.za.services.people.impl;

import cput.ac.za.domain.people.Customer;
import cput.ac.za.repository.people.CustomerRepository;
import cput.ac.za.repository.people.impl.CustomerRepositoryImpl;
import cput.ac.za.services.people.CustomerService;

import java.util.Set;

public class CustomerServiceImpl implements CustomerService {

    private static CustomerServiceImpl service = null;
    private CustomerRepository repository;

    private CustomerServiceImpl() {
        this.repository = CustomerRepositoryImpl.getRepository();
    }

    public static CustomerServiceImpl getService(){
        if (service == null) service = new CustomerServiceImpl();
        return service;
    }

    @Override
    public Customer create(Customer customer) {
        return this.repository.create(customer);
    }

    @Override
    public Customer update(Customer customer) {
        return this.repository.update(customer);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Customer read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Customer> getAll() {
        return this.repository.getAll();
    }
}
