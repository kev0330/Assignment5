package cput.ac.za.services.admin.impl;

import cput.ac.za.domain.admin.Storage;
import cput.ac.za.repository.admin.StorageRepository;
import cput.ac.za.repository.admin.impl.StorageRepImpl;
import cput.ac.za.services.admin.StorageService;

import java.util.Set;

public class StorageServiceImpl implements StorageService {
    private static StorageServiceImpl service = null;
    private StorageRepository repository;

    private StorageServiceImpl() {
        this.repository = StorageRepImpl.getRepository();
    }

    public static StorageServiceImpl getService(){
        if (service == null) service = new StorageServiceImpl();
        return service;
    }

    @Override
    public Storage create(Storage storage) {
        return this.repository.create(storage);
    }

    @Override
    public Storage update(Storage storage) {
        return this.repository.update(storage);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Storage read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Storage> getAll() {
        return this.repository.getAll();
    }
}
