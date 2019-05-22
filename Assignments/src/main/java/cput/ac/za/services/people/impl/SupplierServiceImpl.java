package cput.ac.za.services.people.impl;

import cput.ac.za.domain.people.Supplier;
import cput.ac.za.repository.people.SupplierRepository;
import cput.ac.za.repository.people.impl.SupplierRepositoryImpl;
import cput.ac.za.services.people.SupplierService;

import java.util.Set;

public class SupplierServiceImpl implements SupplierService {

    private static SupplierServiceImpl service = null;
    private SupplierRepository repository;

    private SupplierServiceImpl() {
        this.repository = SupplierRepositoryImpl.getRepository();
    }

    public static SupplierServiceImpl getService(){
        if (service == null) service = new SupplierServiceImpl();
        return service;
    }

    @Override
    public Supplier create(Supplier supplier) {
        return this.repository.create(supplier);
    }

    @Override
    public Supplier update(Supplier supplier) {
        return this.repository.update(supplier);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Supplier read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Supplier> getAll() {
        return this.repository.getAll();
    }
}
