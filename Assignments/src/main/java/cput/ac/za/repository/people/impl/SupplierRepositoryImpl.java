package cput.ac.za.repository.people.impl;


import cput.ac.za.domain.people.Supplier;
import cput.ac.za.repository.admin.impl.ItemRepImpl;
import cput.ac.za.repository.people.SupplierRepository;

import java.util.HashSet;
import java.util.Set;

public class SupplierRepositoryImpl implements SupplierRepository {

    private static SupplierRepositoryImpl repository = null;
    private Set<Supplier> suppliers;

    private SupplierRepositoryImpl(){
        this.suppliers = new HashSet<>();
    }

    private Supplier find(String item) {
        return this.suppliers.stream()
                .filter(ItemNum -> ItemNum.getSupplierID().equals(item))
                .findAny()
                .orElse(null);
    }

    public static SupplierRepositoryImpl getRepository(){
        if(repository == null) repository = new SupplierRepositoryImpl();
        return repository;
    }

    public Supplier create(Supplier item){
        this.suppliers.add(item);
        return item;
    }

    public Supplier read(final String itemNum){
        Supplier item = find(itemNum);
        return item;
    }

    public void delete(String itemNum) {
        Supplier item = find(itemNum);
        if(item != null) this.suppliers.remove(item);
    }

    public Supplier update(Supplier item) {
        Supplier delete = find(item.getSupplierID());
        if(delete != null){
            this.suppliers.remove(delete);
            return create(item);
        }
        return item;
    }

    public Set<Supplier> getAll(){
        return this.suppliers;
    }
}
