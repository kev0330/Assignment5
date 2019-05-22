package cput.ac.za.repository.admin.impl;

import cput.ac.za.domain.admin.City;
import cput.ac.za.domain.admin.Item;
import cput.ac.za.repository.admin.ItemRepository;

import java.util.HashSet;
import java.util.Set;

public class ItemRepImpl implements ItemRepository {

    private static ItemRepImpl repository = null;
    private Set<Item> items;

    private ItemRepImpl(){
        this.items = new HashSet<>();
    }

    private Item find(String item) {
        return this.items.stream()
                .filter(ItemNum -> ItemNum.getItemNum().equals(item))
                .findAny()
                .orElse(null);
    }

    public static ItemRepImpl getRepository(){
        if(repository == null) repository = new ItemRepImpl();
        return repository;
    }

    public Item create(Item item){
        this.items.add(item);
        return item;
    }

    public Item read(final String itemNum){
        Item item = find(itemNum);
        return item;
    }

    public void delete(String itemNum) {
        Item item = find(itemNum);
        if(item != null) this.items.remove(item);
    }

    public Item update(Item item) {
        Item delete = find(item.getItemNum());
        if(delete != null){
            this.items.remove(delete);
            return create(item);
        }
        return item;
    }

    public Set<Item> getAll(){
        return this.items;
    }
}
