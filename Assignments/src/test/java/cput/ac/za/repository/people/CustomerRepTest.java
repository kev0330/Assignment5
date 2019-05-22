package cput.ac.za.repository.people;

import cput.ac.za.domain.people.Customer;
import cput.ac.za.factory.people.CustomerFactory;
import cput.ac.za.repository.people.impl.CustomerRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.IOException;
import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CustomerRepTest {

    private Customer customer;
    private CustomerRepository repository;


    private Customer getSaved() {
        Set<Customer> saved = this.repository.getAll();
        return saved.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = CustomerRepositoryImpl.getRepository();
        this.customer = CustomerFactory.getCustomerID("Customer ID");
    }

    @Test
    public void a_create() throws IOException {
        Customer item = this.repository.create(this.customer);
        Assert.assertSame(item, this.customer);
        System.out.println("Create = " + item);
        d_getAll();
    }

    @Test
    public void b_read(){
        Customer saved = getSaved();
        System.out.println("In read  = " + saved.getCustomerID());
        Customer read = this.repository.read(saved.getCustomerID());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(saved, read);

    }

    @Test
    public void c_update() {
        String newNum = "New ID";
        Customer item = new Customer.Builder().copy(getSaved()).Customer(newNum).build();
        System.out.println("In update, about_to_updated = " + item);
        Customer updated = this.repository.update(item);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newNum, updated.getCustomerID());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Customer> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);

    }

    @Test
    public void e_delete() {
        Customer saved = getSaved();
        this.repository.delete(saved.getCustomerID());
        d_getAll();
    }

}
