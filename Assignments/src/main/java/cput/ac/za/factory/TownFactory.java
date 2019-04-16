package cput.ac.za.factory;

import cput.ac.za.model.Town;


public class TownFactory {
    
    
        public static Town getTownName(String townName) {
        return new Town.Builder().townName(townName)
                .build();
    }



}  