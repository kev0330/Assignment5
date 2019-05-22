package cput.ac.za.services.admin;

import cput.ac.za.domain.admin.Street;
import cput.ac.za.services.IService;

import java.util.Set;

public interface StreetService extends IService<Street, String> {
    Set<Street> getAll();
}
