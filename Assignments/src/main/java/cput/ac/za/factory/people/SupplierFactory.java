package cput.ac.za.factory.people;

import cput.ac.za.domain.people.Supplier;


public class SupplierFactory {
    
    
            public static Supplier getSupplierID(String supplierID) {
        return new Supplier.Builder().Supplier(supplierID)
                .build();
    }



}  