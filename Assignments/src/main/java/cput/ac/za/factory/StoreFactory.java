package cput.ac.za.factory;

import cput.ac.za.model.Store;


public class StoreFactory {
    
    
            public static Store getStoreNum(int storeNum) {
        return new Store.Builder().storeNum(storeNum)
                .build();
    }



}  