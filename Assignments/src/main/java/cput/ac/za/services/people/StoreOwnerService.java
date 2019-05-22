package cput.ac.za.services.people;

import cput.ac.za.domain.people.StoreOwner;
import cput.ac.za.services.IService;

import java.util.Set;

public interface StoreOwnerService extends IService<StoreOwner, String> {
    Set<StoreOwner> getAll();
}
