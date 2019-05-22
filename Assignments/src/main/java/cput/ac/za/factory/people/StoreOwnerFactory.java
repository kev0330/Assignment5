package cput.ac.za.factory.people;

import cput.ac.za.domain.people.StoreOwner;


public class StoreOwnerFactory {
    
    
        public static StoreOwner getStoreOwnerID(String storeOwnerID) {
        return new StoreOwner.Builder().StoreOwner(storeOwnerID)
                .build();
    }

}