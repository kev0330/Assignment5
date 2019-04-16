package cput.ac.za.factory;

import cput.ac.za.model.City;


public class CityFactory {
    
    
       public static City getCityName(String cityName) {
        return new City.Builder().cityName(cityName)
                .build();
    }



}  