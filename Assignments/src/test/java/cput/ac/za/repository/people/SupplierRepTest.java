package cput.ac.za.repository.people;

import cput.ac.za.domain.people.Employee;
import cput.ac.za.domain.people.Supplier;
import cput.ac.za.factory.people.EmployeeFactory;
import cput.ac.za.factory.people.SupplierFactory;
import cput.ac.za.repository.people.impl.EmployeeRepositoryImpl;
import cput.ac.za.repository.people.impl.SupplierRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.IOException;
import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SupplierRepTest {

    private Supplier supplier;
    private SupplierRepository repository;


    private Supplier getSaved() {
        Set<Supplier> saved = this.repository.getAll();
        return saved.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = SupplierRepositoryImpl.getRepository();
        this.supplier = SupplierFactory.getSupplierID("Supplier ID");
    }

    @Test
    public void a_create() throws IOException {
        Supplier item = this.repository.create(this.supplier);
        Assert.assertSame(item, this.supplier);
        System.out.println("Create = " + item);
        d_getAll();
    }

    @Test
    public void b_read(){
        Supplier saved = getSaved();
        System.out.println("In read  = " + saved.getSupplierID());
        Supplier read = this.repository.read(saved.getSupplierID());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(saved, read);

    }

    @Test
    public void c_update() {
        String newNum = "New ID";
        Supplier item = new Supplier.Builder().copy(getSaved()).Supplier(newNum).build();
        System.out.println("In update, about_to_updated = " + item);
        Supplier updated = this.repository.update(item);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newNum, updated.getSupplierID());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Supplier> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);

    }

    @Test
    public void e_delete() {
        Supplier saved = getSaved();
        this.repository.delete(saved.getSupplierID());
        d_getAll();
    }
}
