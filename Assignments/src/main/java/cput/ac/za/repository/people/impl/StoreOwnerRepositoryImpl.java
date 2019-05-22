package cput.ac.za.repository.people.impl;


import cput.ac.za.domain.people.StoreOwner;
import cput.ac.za.repository.admin.impl.ItemRepImpl;
import cput.ac.za.repository.people.StoreOwnerRepository;

import java.util.HashSet;
import java.util.Set;

public class StoreOwnerRepositoryImpl implements StoreOwnerRepository {

    private static StoreOwnerRepositoryImpl repository = null;
    private Set<StoreOwner> storeOwners;

    private StoreOwnerRepositoryImpl(){
        this.storeOwners = new HashSet<>();
    }

    private StoreOwner find(String storeOwners) {
        return this.storeOwners.stream()
                .filter(id -> id.getStoreOwnerID().equals(storeOwners))
                .findAny()
                .orElse(null);
    }

    public static StoreOwnerRepositoryImpl getRepository(){
        if(repository == null) repository = new StoreOwnerRepositoryImpl();
        return repository;
    }

    public StoreOwner create(StoreOwner storeOwner){
        this.storeOwners.add(storeOwner);
        return storeOwner;
    }

    public StoreOwner read(final String storeOwners){
        StoreOwner owner = find(storeOwners);
        return owner;
    }

    public void delete(String itemNum) {
        StoreOwner item = find(itemNum);
        if(item != null) this.storeOwners.remove(item);
    }

    public StoreOwner update(StoreOwner item) {
        StoreOwner delete = find(item.getStoreOwnerID());
        if(delete != null){
            this.storeOwners.remove(delete);
            return create(item);
        }
        return item;
    }

    public Set<StoreOwner> getAll(){
        return this.storeOwners;
    }
}
