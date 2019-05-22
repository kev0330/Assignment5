package cput.ac.za.services.people;

import cput.ac.za.domain.people.Customer;
import cput.ac.za.services.IService;

import java.util.Set;

public interface CustomerService extends IService<Customer, String> {
    Set<Customer> getAll();
}
