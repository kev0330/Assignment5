package cput.ac.za.services.admin.impl;

import cput.ac.za.domain.admin.Store;
import cput.ac.za.repository.admin.StoreRepository;
import cput.ac.za.repository.admin.impl.StoreRepImpl;
import cput.ac.za.services.admin.StoreService;

import java.util.Set;

public class StoreServiceImpl implements StoreService {

    private static StoreServiceImpl service = null;
    private StoreRepository repository;

    private StoreServiceImpl() {
        this.repository = StoreRepImpl.getRepository();
    }

    public static StoreServiceImpl getService(){
        if (service == null) service = new StoreServiceImpl();
        return service;
    }

    @Override
    public Store create(Store store) {
        return this.repository.create(store);
    }

    @Override
    public Store update(Store store) {
        return this.repository.update(store);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Store read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Store> getAll() {
        return this.repository.getAll();
    }
}
