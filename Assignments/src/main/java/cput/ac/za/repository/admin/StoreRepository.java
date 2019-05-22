package cput.ac.za.repository.admin;


import cput.ac.za.domain.admin.Store;
import cput.ac.za.repository.IRepository;

import java.util.Set;

public interface StoreRepository  extends IRepository<Store, String> {

    Set<Store> getAll();
}
