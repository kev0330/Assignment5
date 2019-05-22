package cput.ac.za.repository.people;


import cput.ac.za.domain.people.StoreOwner;

import cput.ac.za.factory.people.StoreOwnerFactory;
import cput.ac.za.repository.people.impl.StoreOwnerRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.IOException;
import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StoreOwnerRepTest {

    private StoreOwner storeOwner;
    private StoreOwnerRepository repository;


    private StoreOwner getSaved() {
        Set<StoreOwner> saved = this.repository.getAll();
        return saved.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = StoreOwnerRepositoryImpl.getRepository();
        this.storeOwner = StoreOwnerFactory.getStoreOwnerID("StoreOwner ID");
    }

    @Test
    public void a_create() throws IOException {
        StoreOwner item = this.repository.create(this.storeOwner);
        Assert.assertSame(item, this.storeOwner);
        System.out.println("Create = " + item);
        d_getAll();
    }

    @Test
    public void b_read(){
        StoreOwner saved = getSaved();
        System.out.println("In read  = " + saved.getStoreOwnerID());
        StoreOwner read = this.repository.read(saved.getStoreOwnerID());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(saved, read);

    }

    @Test
    public void c_update() {
        String newNum = "New ID";
        StoreOwner item = new StoreOwner.Builder().copy(getSaved()).StoreOwner(newNum).build();
        System.out.println("In update, about_to_updated = " + item);
        StoreOwner updated = this.repository.update(item);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newNum, updated.getStoreOwnerID());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<StoreOwner> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);

    }

    @Test
    public void e_delete() {
        StoreOwner saved = getSaved();
        this.repository.delete(saved.getStoreOwnerID());
        d_getAll();
    }
}
