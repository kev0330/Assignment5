package cput.ac.za.factory;

import cput.ac.za.model.Supplier;


public class SupplierFactory {
    
    
            public static Supplier getSupplierID(int supplierID) {
        return new Supplier.Builder().supplierID(supplierID)
                .build();
    }



}  