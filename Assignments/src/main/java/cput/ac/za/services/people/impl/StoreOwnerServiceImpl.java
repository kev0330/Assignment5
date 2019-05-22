package cput.ac.za.services.people.impl;

import cput.ac.za.domain.people.StoreOwner;
import cput.ac.za.repository.people.StoreOwnerRepository;
import cput.ac.za.repository.people.impl.StoreOwnerRepositoryImpl;
import cput.ac.za.services.people.StoreOwnerService;

import java.util.Set;

public class StoreOwnerServiceImpl implements StoreOwnerService {

    private static StoreOwnerServiceImpl service = null;
    private StoreOwnerRepository repository;

    private StoreOwnerServiceImpl() {
        this.repository = StoreOwnerRepositoryImpl.getRepository();
    }

    public static StoreOwnerServiceImpl getService(){
        if (service == null) service = new StoreOwnerServiceImpl();
        return service;
    }

    @Override
    public StoreOwner create(StoreOwner storeOwner) {
        return this.repository.create(storeOwner);
    }

    @Override
    public StoreOwner update(StoreOwner storeOwner) {
        return this.repository.update(storeOwner);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public StoreOwner read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<StoreOwner> getAll() {
        return this.repository.getAll();
    }
}
