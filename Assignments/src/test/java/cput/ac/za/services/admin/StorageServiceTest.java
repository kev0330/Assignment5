package cput.ac.za.services.admin;

import cput.ac.za.domain.admin.Storage;
import cput.ac.za.factory.admin.StorageFactory;
import cput.ac.za.repository.admin.impl.StorageRepImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StorageServiceTest {

    private StorageRepImpl repository;
    private Storage storage;

    private Storage getSavedName(){
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = StorageRepImpl.getRepository();
        this.storage = StorageFactory.getStorageNum("Storage Number");
    }

    @Test
    public void a_create() {
        Storage created = this.repository.create(this.storage);
        System.out.println("created : " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.storage);
    }

    @Test
    public void b_read() {
        Storage saved = getSavedName();
        Storage read = this.repository.read(saved.getStorageNum());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void c_update() {
        String newName = "New Number";
        Storage updated = new Storage.Builder().copy(getSavedName()).Storage(newName).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newName, updated.getStorageNum());
    }

    @Test
    public void d_getAll() {
        Set<Storage> storage = this.repository.getAll();
        System.out.println("all = " + storage);
    }

    @Test
    public void e_delete() {
        Storage saved = getSavedName();
        this.repository.delete(saved.getStorageNum());
        d_getAll();
    }

}
