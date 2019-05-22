package cput.ac.za.factory.admin;

import cput.ac.za.domain.admin.Town;


public class TownFactory {
    
    
        public static Town getTownName(String townName) {
        return new Town.Builder().townName(townName)
                .build();
    }



}  