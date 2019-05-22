package cput.ac.za.services.people;

import cput.ac.za.domain.people.Supplier;
import cput.ac.za.services.IService;

import java.util.Set;

public interface SupplierService extends IService<Supplier, String> {
    Set< Supplier> getAll();
}
