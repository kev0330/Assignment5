package cput.ac.za.repository.people.impl;


import cput.ac.za.domain.people.Customer;
import cput.ac.za.repository.admin.impl.ItemRepImpl;
import cput.ac.za.repository.people.CustomerRepository;

import java.util.HashSet;
import java.util.Set;

public class CustomerRepositoryImpl implements CustomerRepository {

    private static CustomerRepositoryImpl repository = null;
    private Set<Customer> customers;

    private CustomerRepositoryImpl(){
        this.customers = new HashSet<>();
    }

    private Customer find(String customer) {
        return this.customers.stream()
                .filter(id -> id.getCustomerID().equals(customer))
                .findAny()
                .orElse(null);
    }

    public static CustomerRepositoryImpl getRepository(){
        if(repository == null) repository = new CustomerRepositoryImpl();
        return repository;
    }

    public Customer create(Customer customer){
        this.customers.add(customer);
        return customer;
    }

    public Customer read(final String itemNum){
        Customer item = find(itemNum);
        return item;
    }

    public void delete(String itemNum) {
        Customer item = find(itemNum);
        if(item != null) this.customers.remove(item);
    }

    public Customer update(Customer customer) {
        Customer delete = find(customer.getCustomerID());
        if(delete != null){
            this.customers.remove(delete);
            return create(customer);
        }
        return customer;
    }

    public Set<Customer> getAll(){
        return this.customers;
    }
}
