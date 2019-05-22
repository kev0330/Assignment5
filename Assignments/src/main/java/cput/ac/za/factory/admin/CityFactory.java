package cput.ac.za.factory.admin;

import cput.ac.za.domain.admin.City;


public class CityFactory {
    
    
       public static City getCityName(String cityName) {
        return new City.Builder().cityName(cityName)
                .build();
    }



}  