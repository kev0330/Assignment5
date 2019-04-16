package cput.ac.za.factory;

import cput.ac.za.model.Customer;

public class CustomerFactory {
    
     public static Customer getCustomerID(int customerID) {
        return new Customer.Builder().customerID.customerID(customerID)    
                .build();
    }

}   




