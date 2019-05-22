package cput.ac.za.repository.admin;


import cput.ac.za.domain.admin.Storage;

import cput.ac.za.factory.admin.StorageFactory;
import cput.ac.za.repository.admin.impl.ItemRepImpl;
import cput.ac.za.repository.admin.impl.StockRepImpl;
import cput.ac.za.repository.admin.impl.StorageRepImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.IOException;
import java.util.Set;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StorageRepositoryTest {

    private Storage storage;
    private StorageRepository repository;


    private Storage getSaved() {
        Set<Storage> saved = this.repository.getAll();
        return saved.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = StorageRepImpl.getRepository();
        this.storage = StorageFactory.getStorageNum("Storage Number");
    }

    @Test
    public void a_create() throws IOException {
        Storage storage = this.repository.create(this.storage);
        Assert.assertSame(storage, this.storage);
        System.out.println("Create = " + storage);
        d_getAll();
    }

    @Test
    public void b_read(){
        Storage saved = getSaved();
        System.out.println("In read, cityName = " + saved.getStorageNum());
        Storage read = this.repository.read(saved.getStorageNum());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(saved, read);

    }

    @Test
    public void c_update() {
        String newNum = "New Number";
        Storage storage = new Storage.Builder().copy(getSaved()).Storage(newNum).build();
        System.out.println("In update, about_to_updated = " + storage);
        Storage updated = this.repository.update(storage);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newNum, updated.getStorageNum());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Storage> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);

    }

    @Test
    public void e_delete() {
        Storage saved = getSaved();
        this.repository.delete(saved.getStorageNum());
        d_getAll();
    }


}
