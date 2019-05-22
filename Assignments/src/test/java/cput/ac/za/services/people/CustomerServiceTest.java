package cput.ac.za.services.people;

import cput.ac.za.domain.people.Customer;
import cput.ac.za.factory.people.CustomerFactory;
import cput.ac.za.repository.people.impl.CustomerRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CustomerServiceTest {



    private CustomerRepositoryImpl repository;
    private Customer customer;

    private Customer getSavedName(){
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = CustomerRepositoryImpl.getRepository();
        this.customer = CustomerFactory.getCustomerID("Customer ID" );
    }

    @Test
    public void a_create() {
        Customer created = this.repository.create(this.customer);
        System.out.println("created : " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.customer);
    }

    @Test
    public void b_read() {
        Customer saved = getSavedName();
        Customer read = this.repository.read(saved.getCustomerID());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void c_update() {
        String newName = "New Number";
        Customer updated = new Customer.Builder().copy(getSavedName()).Customer(newName).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newName, updated.getCustomerID());
    }

    @Test
    public void d_getAll() {
        Set<Customer> customer = this.repository.getAll();
        System.out.println("all = " + customer);
    }

    @Test
    public void e_delete() {
        Customer saved = getSavedName();
        this.repository.delete(saved.getCustomerID());
        d_getAll();
    }
}
