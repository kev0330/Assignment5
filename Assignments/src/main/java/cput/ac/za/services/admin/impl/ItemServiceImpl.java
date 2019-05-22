package cput.ac.za.services.admin.impl;


import cput.ac.za.domain.admin.Item;
import cput.ac.za.repository.admin.ItemRepository;
import cput.ac.za.repository.admin.impl.ItemRepImpl;
import cput.ac.za.services.admin.ItemService;

import java.util.Set;

public class ItemServiceImpl implements ItemService {

    private static ItemServiceImpl service = null;
    private ItemRepository repository;

    private ItemServiceImpl() {
        this.repository = ItemRepImpl.getRepository();
    }

    public static ItemServiceImpl getService(){
        if (service == null) service = new ItemServiceImpl();
        return service;
    }

    @Override
    public Item create(Item item) {
        return this.repository.create(item);
    }

    @Override
    public Item update(Item item) {
        return this.repository.update(item);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Item read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Item> getAll() {
        return this.repository.getAll();
    }
}
