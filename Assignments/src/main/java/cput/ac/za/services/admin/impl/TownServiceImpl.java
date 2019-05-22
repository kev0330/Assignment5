package cput.ac.za.services.admin.impl;

import cput.ac.za.domain.admin.Town;
import cput.ac.za.repository.admin.TownRepository;
import cput.ac.za.repository.admin.impl.TownRepImpl;
import cput.ac.za.services.admin.TownService;

import java.util.Set;

public class TownServiceImpl implements TownService {

    private static TownServiceImpl service = null;
    private TownRepository repository;

    private TownServiceImpl() {
        this.repository = TownRepImpl.getRepository();
    }

    public static TownServiceImpl getService(){
        if (service == null) service = new TownServiceImpl();
        return service;
    }

    @Override
    public Town create(Town town) {
        return this.repository.create(town);
    }

    @Override
    public Town update(Town town) {
        return this.repository.update(town);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Town read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Town> getAll() {
        return this.repository.getAll();
    }
}
