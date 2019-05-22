package cput.ac.za.services.admin;

import cput.ac.za.domain.admin.Store;
import cput.ac.za.services.IService;

import java.util.Set;

public interface StoreService extends IService<Store, String> {
    Set<Store> getAll();
}
