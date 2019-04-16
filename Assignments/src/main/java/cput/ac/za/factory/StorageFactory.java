package cput.ac.za.factory;

import cput.ac.za.model.Storage;


public class StorageFactory {
    
    
        
    public static Storage getStorageNum(int storageNum) {
        return new Storage.Builder().storageNum(storageNum)
                .build();
    }


}  