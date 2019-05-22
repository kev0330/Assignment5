package cput.ac.za.services.admin;

import cput.ac.za.domain.admin.Town;
import cput.ac.za.services.IService;

import java.util.Set;

public interface TownService extends IService<Town, String> {
    Set<Town> getAll();
}
