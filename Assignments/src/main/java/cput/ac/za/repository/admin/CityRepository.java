package cput.ac.za.repository.admin;

import cput.ac.za.domain.admin.City;
import cput.ac.za.repository.IRepository;

import java.util.Set;

public interface CityRepository extends IRepository<City, String> {
    Set<City> getAll();
}
