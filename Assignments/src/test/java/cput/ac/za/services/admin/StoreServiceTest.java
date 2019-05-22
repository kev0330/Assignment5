package cput.ac.za.services.admin;

import cput.ac.za.domain.admin.Store;
import cput.ac.za.factory.admin.StoreFactory;
import cput.ac.za.repository.admin.impl.StoreRepImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StoreServiceTest {

    private StoreRepImpl repository;
    private Store store;

    private Store getSavedName(){
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = StoreRepImpl.getRepository();
        this.store = StoreFactory.getStoreNum("Store Number");
    }

    @Test
    public void a_create() {
        Store created = this.repository.create(this.store);
        System.out.println("created : " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.store);
    }

    @Test
    public void b_read() {
        Store saved = getSavedName();
        Store read = this.repository.read(saved.getStoreNum());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void c_update() {
        String newName = "New Number";
        Store updated = new Store.Builder().copy(getSavedName()).Store(newName).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newName, updated.getStoreNum());
    }

    @Test
    public void d_getAll() {
        Set<Store> store = this.repository.getAll();
        System.out.println("all = " + store);
    }

    @Test
    public void e_delete() {
        Store saved = getSavedName();
        this.repository.delete(saved.getStoreNum());
        d_getAll();
    }

}
