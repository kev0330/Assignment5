package cput.ac.za.repository.admin;


import cput.ac.za.domain.admin.Item;
import cput.ac.za.repository.IRepository;

import java.util.Set;

public interface ItemRepository extends IRepository<Item, String> {
    Set<Item> getAll();

}
