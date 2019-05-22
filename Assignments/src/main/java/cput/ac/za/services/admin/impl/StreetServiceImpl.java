package cput.ac.za.services.admin.impl;

import cput.ac.za.domain.admin.Street;
import cput.ac.za.repository.admin.StreetRepository;
import cput.ac.za.repository.admin.impl.StreetRepImpl;
import cput.ac.za.services.admin.StreetService;

import java.util.Set;

public class StreetServiceImpl implements StreetService {

    private static StreetServiceImpl service = null;
    private StreetRepository repository;

    private StreetServiceImpl() {
        this.repository = StreetRepImpl.getRepository();
    }

    public static StreetServiceImpl getService(){
        if (service == null) service = new StreetServiceImpl();
        return service;
    }

    @Override
    public Street create(Street street) {
        return this.repository.create(street);
    }

    @Override
    public Street update(Street street) {
        return this.repository.update(street);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Street read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Street> getAll() {
        return this.repository.getAll();
    }
}
