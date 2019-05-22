package cput.ac.za.repository.admin;

import cput.ac.za.domain.admin.Storage;
import cput.ac.za.repository.IRepository;

import java.util.Set;

public interface StorageRepository  extends IRepository<Storage, String> {

    Set<Storage> getAll();
}
