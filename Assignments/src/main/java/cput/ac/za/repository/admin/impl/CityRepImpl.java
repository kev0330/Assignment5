package cput.ac.za.repository.admin.impl;

import cput.ac.za.domain.admin.City;
import cput.ac.za.repository.admin.CityRepository;

import java.util.*;

public class CityRepImpl implements CityRepository {

    private static CityRepImpl repository = null;
    private Set<City> cities;

    private CityRepImpl(){
        this.cities = new HashSet<>();
    }

    private City findCity(String city) {
        return this.cities.stream()
                .filter(cityName -> cityName.getCityName().equals(city))
                .findAny()
                .orElse(null);
    }

    public static CityRepImpl getRepository(){
        if(repository == null) repository = new CityRepImpl();
        return repository;
    }

    public City create(City city){
        this.cities.add(city);
        return city;
    }

    public City read(final String cityName){
        City city = findCity(cityName);
        return city;
    }

    public void delete(String cityName) {
        City city = findCity(cityName);
        if(city != null) this.cities.remove(city);
    }

    public City update(City city) {
        City delete = findCity(city.getCityName());
        if(delete != null){
            this.cities.remove(delete);
            return create(city);
        }
        return city;
    }

    public Set<City> getAll(){
        return this.cities;
    }
}
