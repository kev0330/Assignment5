package cput.ac.za.repository.admin;

import cput.ac.za.domain.admin.Street;
import cput.ac.za.domain.admin.Town;
import cput.ac.za.repository.IRepository;

import java.util.Set;

public interface StreetRepository  extends IRepository<Street, String> {
    Set<Street> getAll();
}
