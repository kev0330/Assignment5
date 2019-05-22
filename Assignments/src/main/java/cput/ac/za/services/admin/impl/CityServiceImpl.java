package cput.ac.za.services.admin.impl;

import cput.ac.za.services.admin.CityService;
import cput.ac.za.domain.admin.City;
import cput.ac.za.repository.admin.CityRepository;
import cput.ac.za.repository.admin.impl.CityRepImpl;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CityServiceImpl implements CityService {

    private static CityServiceImpl service = null;
    private CityRepository repository;

    private CityServiceImpl() {
        this.repository = CityRepImpl.getRepository();
    }

    public static CityServiceImpl getService(){
        if (service == null) service = new CityServiceImpl();
        return service;
    }

    @Override
    public City create(City city) {
        return this.repository.create(city);
    }

    @Override
    public City update(City city) {
        return this.repository.update(city);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public City read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<City> getAll() {
        return this.repository.getAll();
    }
}
