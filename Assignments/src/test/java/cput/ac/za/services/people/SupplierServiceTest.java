package cput.ac.za.services.people;

import cput.ac.za.domain.people.Supplier;
import cput.ac.za.factory.people.SupplierFactory;
import cput.ac.za.repository.people.SupplierRepository;
import cput.ac.za.repository.people.impl.SupplierRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SupplierServiceTest {



    private SupplierRepositoryImpl repository;
    private Supplier supplier;

    private Supplier getSavedName(){
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = SupplierRepositoryImpl.getRepository();
        this.supplier = SupplierFactory.getSupplierID("Supplier ID");
    }

    @Test
    public void a_create() {
        Supplier created = this.repository.create(this.supplier);
        System.out.println("created : " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.supplier);
    }

    @Test
    public void b_read() {
        Supplier saved = getSavedName();
        Supplier read = this.repository.read(saved.getSupplierID());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void c_update() {
        String newName = "New Number";
        Supplier updated = new Supplier.Builder().copy(getSavedName()).Supplier(newName).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newName, updated.getSupplierID());
    }

    @Test
    public void d_getAll() {
        Set<Supplier> city = this.repository.getAll();
        System.out.println("all = " + city);
    }

    @Test
    public void e_delete() {
        Supplier saved = getSavedName();
        this.repository.delete(saved.getSupplierID());
        d_getAll();
    }
}
