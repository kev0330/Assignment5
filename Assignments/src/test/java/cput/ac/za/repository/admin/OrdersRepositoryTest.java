package cput.ac.za.repository.admin;


import cput.ac.za.domain.admin.Orders;

import cput.ac.za.factory.admin.OrdersFactory;
import cput.ac.za.repository.admin.impl.ItemRepImpl;
import cput.ac.za.repository.admin.impl.OrdersRepImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.IOException;
import java.util.Set;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OrdersRepositoryTest {

    private Orders orders;
    private OrdersRepository repository;


    private Orders getSaved() {
        Set<Orders> saved = this.repository.getAll();
        return saved.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = OrdersRepImpl.getRepository();
        this.orders = OrdersFactory.getOrderNum("Order Number");
    }

    @Test
    public void a_create() throws IOException {
        Orders orders = this.repository.create(this.orders);
        Assert.assertSame(orders, this.orders);
        System.out.println("Create = " + orders);
        d_getAll();
    }

    @Test
    public void b_read(){
        Orders saved = getSaved();
        System.out.println("In read, cityName = " + saved.getOrderNum());
        Orders read = this.repository.read(saved.getOrderNum());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(saved, read);

    }

    @Test
    public void c_update() {
        String newNum = "New Number";
        Orders item = new Orders.Builder().copy(getSaved()).Orders(newNum).build();
        System.out.println("In update, about_to_updated = " + item);
        Orders updated = this.repository.update(item);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newNum, updated.getOrderNum());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Orders> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);

    }

    @Test
    public void e_delete() {
        Orders saved = getSaved();
        this.repository.delete(saved.getOrderNum());
        d_getAll();
    }


}
