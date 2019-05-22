package cput.ac.za.repository.admin.impl;


import cput.ac.za.domain.admin.Store;
import cput.ac.za.repository.admin.StoreRepository;

import java.util.HashSet;
import java.util.Set;

public class StoreRepImpl implements StoreRepository {
    private static StoreRepImpl repository = null;
    private Set<Store> stores;

    private StoreRepImpl(){
        this.stores = new HashSet<>();
    }

    private Store find(String stores) {
        return this.stores.stream()
                .filter(store -> store.getStoreNum().equals(stores))
                .findAny()
                .orElse(null);
    }

    public static StoreRepImpl getRepository(){
        if(repository == null) repository = new StoreRepImpl();
        return repository;
    }

    public Store create(Store store){
        this.stores.add(store);
        return store;
    }

    public Store read(final String storeNum){
        Store store = find(storeNum);
        return store;
    }

    public void delete(String storeNum) {
        Store market = find(storeNum);
        if(market != null) this.stores.remove(market);
    }

    public Store update(Store store) {
        Store delete = find(store.getStoreNum());
        if(delete != null){
            this.stores.remove(delete);
            return create(store);
        }
        return store;
    }

    public Set<Store> getAll(){
        return this.stores;
    }
}
