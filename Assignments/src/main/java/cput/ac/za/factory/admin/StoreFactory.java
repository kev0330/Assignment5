package cput.ac.za.factory.admin;

import cput.ac.za.domain.admin.Store;


public class StoreFactory {
    
    
            public static Store getStoreNum(String storeNum) {
        return new Store.Builder().Store(storeNum)
                .build();
    }



}  