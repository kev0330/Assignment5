package cput.ac.za.factory.admin;

import cput.ac.za.domain.admin.Street;


public class StreetFactory {
    
    
            public static Street getStreetNum(String streetNum) {
        return new Street.Builder().streetNum(streetNum)
                .build();
    }



}  