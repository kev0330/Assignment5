package cput.ac.za.repository.people;

import cput.ac.za.domain.people.Supplier;
import cput.ac.za.repository.IRepository;

import java.util.Set;

public interface SupplierRepository extends IRepository<Supplier, String> {
    Set<Supplier> getAll();
}
