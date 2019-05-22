package cput.ac.za.services.admin;

import cput.ac.za.domain.admin.Storage;
import cput.ac.za.services.IService;

import java.util.Set;

public interface StorageService extends IService<Storage, String> {
    Set<Storage> getAll();
}
