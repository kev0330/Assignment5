package cput.ac.za.services.admin;

import cput.ac.za.services.IService;
import cput.ac.za.domain.admin.City;

import java.util.Set;

public interface CityService extends IService<City, String> {
    Set<City> getAll();
}
