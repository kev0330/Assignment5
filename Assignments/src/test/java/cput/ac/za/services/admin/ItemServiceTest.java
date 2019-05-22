package cput.ac.za.services.admin;

import cput.ac.za.domain.admin.Item;
import cput.ac.za.factory.admin.ItemFactory;
import cput.ac.za.repository.admin.impl.ItemRepImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ItemServiceTest {


    private ItemRepImpl repository;
    private Item item;

    private Item getSavedName(){
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = ItemRepImpl.getRepository();
        this.item = ItemFactory.getItemNum("Item number");
    }

    @Test
    public void a_create() {
        Item created = this.repository.create(this.item);
        System.out.println("created : " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.item);
    }

    @Test
    public void b_read() {
        Item saved = getSavedName();
        Item read = this.repository.read(saved.getItemNum());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void c_update() {
        String newName = "New Number";
        Item updated = new Item.Builder().copy(getSavedName()).Item(newName).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newName, updated.getItemNum());
    }

    @Test
    public void d_getAll() {
        Set<Item> item = this.repository.getAll();
        System.out.println("all = " + item);
    }

    @Test
    public void e_delete() {
        Item saved = getSavedName();
        this.repository.delete(saved.getItemNum());
        d_getAll();
    }

}
