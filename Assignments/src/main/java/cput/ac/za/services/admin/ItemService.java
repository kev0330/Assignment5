package cput.ac.za.services.admin;

import cput.ac.za.domain.admin.Item;
import cput.ac.za.services.IService;

import java.util.Set;

public interface ItemService extends IService<Item, String> {
    Set<Item> getAll();
}
