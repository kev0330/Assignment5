package cput.ac.za.repository.people;

import cput.ac.za.domain.people.StoreOwner;
import cput.ac.za.repository.IRepository;

import java.util.Set;

public interface StoreOwnerRepository extends IRepository<StoreOwner, String> {
    Set<StoreOwner> getAll();
}
