package cput.ac.za.services.people;

import cput.ac.za.domain.people.StoreOwner;
import cput.ac.za.factory.people.StoreOwnerFactory;
import cput.ac.za.repository.people.impl.StoreOwnerRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StoreOwnerServiceTest {



    private StoreOwnerRepositoryImpl repository;
    private StoreOwner storeOwner;

    private StoreOwner getSavedName(){
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = StoreOwnerRepositoryImpl.getRepository();
        this.storeOwner = StoreOwnerFactory.getStoreOwnerID("storeOwner ID");
    }

    @Test
    public void a_create() {
        StoreOwner created = this.repository.create(this.storeOwner);
        System.out.println("created : " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.storeOwner);
    }

    @Test
    public void b_read() {
        StoreOwner saved = getSavedName();
        StoreOwner read = this.repository.read(saved.getStoreOwnerID());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void c_update() {
        String newName = "New Number";
        StoreOwner updated = new StoreOwner.Builder().copy(getSavedName()).StoreOwner(newName).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newName, updated.getStoreOwnerID());
    }

    @Test
    public void d_getAll() {
        Set<StoreOwner> storeOwner = this.repository.getAll();
        System.out.println("all = " + storeOwner);
    }

    @Test
    public void e_delete() {
        StoreOwner saved = getSavedName();
        this.repository.delete(saved.getStoreOwnerID());
        d_getAll();
    }
}
