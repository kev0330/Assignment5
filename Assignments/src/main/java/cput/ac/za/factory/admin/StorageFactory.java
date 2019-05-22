package cput.ac.za.factory.admin;

import cput.ac.za.domain.admin.Storage;


public class StorageFactory {
    
    
        
    public static Storage getStorageNum(String storageNum) {
        return new Storage.Builder().Storage(storageNum)
                .build();
    }


}  