package cput.ac.za.factory.people;

import cput.ac.za.domain.people.Customer;

public class CustomerFactory {
    
     public static Customer getCustomerID(String customerID) {
        return new Customer.Builder().Customer(customerID)
                .build();
    }

}   




