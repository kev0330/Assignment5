package cput.ac.za.repository.admin;

import cput.ac.za.domain.admin.Item;
import cput.ac.za.factory.admin.CityFactory;
import cput.ac.za.factory.admin.ItemFactory;
import cput.ac.za.repository.admin.impl.CityRepImpl;
import cput.ac.za.repository.admin.impl.ItemRepImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.IOException;
import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ItemRepositoryTest {

    private Item item;
    private ItemRepository repository;


    private Item getSaved() {
        Set<Item> saved = this.repository.getAll();
        return saved.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = ItemRepImpl.getRepository();
        this.item = ItemFactory.getItemNum("Item Number");
    }

    @Test
    public void a_create() throws IOException {
        Item item = this.repository.create(this.item);
        Assert.assertSame(item, this.item);
        System.out.println("Create = " + item);
        d_getAll();
    }

    @Test
    public void b_read(){
        Item saved = getSaved();
        System.out.println("In read = " + saved.getItemNum());
        Item read = this.repository.read(saved.getItemNum());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(saved, read);

    }

    @Test
    public void c_update() {
        String newNum = "New Number";
        Item item = new Item.Builder().copy(getSaved()).Item(newNum).build();
        System.out.println("In update, about_to_updated = " + item);
        Item updated = this.repository.update(item);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newNum, updated.getItemNum());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Item> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);

    }

    @Test
    public void e_delete() {
        Item saved = getSaved();
        this.repository.delete(saved.getItemNum());
        d_getAll();
    }


}
