package cput.ac.za.repository.admin;



import cput.ac.za.domain.admin.Store;
import cput.ac.za.factory.admin.StoreFactory;
import cput.ac.za.repository.admin.impl.StoreRepImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.IOException;
import java.util.Set;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StoreRepositoryTest {

    private Store store;
    private StoreRepository repository;


    private Store getSaved() {
        Set<Store> saved = this.repository.getAll();
        return saved.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = StoreRepImpl.getRepository();
        this.store = StoreFactory.getStoreNum("Store Number");
    }

    @Test
    public void a_create() throws IOException {
        Store store = this.repository.create(this.store);
        Assert.assertSame(store, this.store);
        System.out.println("Create = " + store);
        d_getAll();
    }

    @Test
    public void b_read(){
        Store saved = getSaved();
        System.out.println("In read, cityName = " + saved.getStoreNum());
        Store read = this.repository.read(saved.getStoreNum());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(saved, read);

    }

    @Test
    public void c_update() {
        String newNum = "New Number";
        Store item = new Store.Builder().copy(getSaved()).Store(newNum).build();
        System.out.println("In update, about_to_updated = " + item);
        Store updated = this.repository.update(item);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newNum, updated.getStoreNum());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Store> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);

    }

    @Test
    public void e_delete() {
        Store saved = getSaved();
        this.repository.delete(saved.getStoreNum());
        d_getAll();
    }


}
