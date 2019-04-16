package cput.ac.za.factory;

import cput.ac.za.model.Street;


public class StreetFactory {
    
    
            public static Street getStreetNum(int streetNum) {
        return new Street.Builder().streetNum(streetNum)
                .build();
    }



}  