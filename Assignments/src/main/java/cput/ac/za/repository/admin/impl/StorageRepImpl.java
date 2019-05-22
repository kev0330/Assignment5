package cput.ac.za.repository.admin.impl;

import cput.ac.za.domain.admin.Storage;
import cput.ac.za.repository.admin.StockRepository;
import cput.ac.za.repository.admin.StorageRepository;

import java.util.HashSet;
import java.util.Set;

public class StorageRepImpl implements StorageRepository {
    private static StorageRepImpl repository = null;
    private Set<Storage> storages;

    private StorageRepImpl(){
        this.storages = new HashSet<>();
    }

    private Storage find(String storage) {
        return this.storages.stream()
                .filter(storages -> storages.getStorageNum().equals(storage))
                .findAny()
                .orElse(null);
    }

    public static StorageRepImpl getRepository(){
        if(repository == null) repository = new StorageRepImpl();
        return repository;
    }

    public Storage create(Storage storage){
        this.storages.add(storage);
        return storage;
    }

    public Storage read(final String storageNum){
        Storage storage = find(storageNum);
        return storage;
    }

    public void delete(String storageNum) {
        Storage storage = find(storageNum);
        if(storage != null) this.storages.remove(storage);
    }

    public Storage update(Storage storage) {
        Storage delete = find(storage.getStorageNum());
        if(delete != null){
            this.storages.remove(delete);
            return create(storage);
        }
        return storage;
    }

    public Set<Storage> getAll(){
        return this.storages;
    }
}
