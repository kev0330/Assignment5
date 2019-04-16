package cput.ac.za.factory;

import cput.ac.za.model.StoreOwner;


public class StoreOwnerFactory {
    
    
        public static StoreOwner getStoreOwnerID(int storeOwnerID) {
        return new StoreOwner.Builder().storeOwnerID(storeOwnerID)
                .build();
    }

}