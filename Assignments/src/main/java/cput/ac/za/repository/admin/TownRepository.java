package cput.ac.za.repository.admin;

import cput.ac.za.domain.admin.Town;
import cput.ac.za.repository.IRepository;

import java.util.Set;

public interface TownRepository  extends IRepository<Town, String> {
    Set<Town> getAll();
}
