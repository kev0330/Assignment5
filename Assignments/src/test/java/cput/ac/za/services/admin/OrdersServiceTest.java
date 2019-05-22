package cput.ac.za.services.admin;

import cput.ac.za.domain.admin.Orders;
import cput.ac.za.factory.admin.OrdersFactory;
import cput.ac.za.repository.admin.impl.OrdersRepImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OrdersServiceTest {


    private OrdersRepImpl repository;
    private Orders orders;

    private Orders getSavedName(){
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = OrdersRepImpl.getRepository();
        this.orders = OrdersFactory.getOrderNum("Order Number");
    }

    @Test
    public void a_create() {
        Orders created = this.repository.create(this.orders);
        System.out.println("created : " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.orders);
    }

    @Test
    public void b_read() {
        Orders saved = getSavedName();
        Orders read = this.repository.read(saved.getOrderNum());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void c_update() {
        String newName = "New Number";
        Orders updated = new Orders.Builder().copy(getSavedName()).Orders(newName).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newName, updated.getOrderNum());
    }

    @Test
    public void d_getAll() {
        Set<Orders> city = this.repository.getAll();
        System.out.println("all = " + city);
    }

    @Test
    public void e_delete() {
        Orders saved = getSavedName();
        this.repository.delete(saved.getOrderNum());
        d_getAll();
    }

}
