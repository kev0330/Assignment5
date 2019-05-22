package cput.ac.za.repository.admin;


import cput.ac.za.domain.admin.Stock;
import cput.ac.za.factory.admin.StockFactory;
import cput.ac.za.repository.admin.impl.ItemRepImpl;
import cput.ac.za.repository.admin.impl.StockRepImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.IOException;
import java.util.Set;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StockRepositoryTest {

    private Stock stock;
    private StockRepository repository;


    private Stock getSaved() {
        Set<Stock> saved = this.repository.getAll();
        return saved.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = StockRepImpl.getRepository();
        this.stock = StockFactory.getStockNum("Stock Number");
    }

    @Test
    public void a_create() throws IOException {
        Stock stock = this.repository.create(this.stock);
        Assert.assertSame(stock, this.stock);
        System.out.println("Create = " + stock);
        d_getAll();
    }

    @Test
    public void b_read(){
        Stock saved = getSaved();
        System.out.println("In read, cityName = " + saved.getStockNum());
        Stock read = this.repository.read(saved.getStockNum());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(saved, read);

    }

    @Test
    public void c_update() {
        String newNum = "New Number";
        Stock item = new Stock.Builder().copy(getSaved()).Stock(newNum).build();
        System.out.println("In update, about_to_updated = " + item);
        Stock updated = this.repository.update(item);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newNum, updated.getStockNum());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Stock> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);

    }

    @Test
    public void e_delete() {
        Stock saved = getSaved();
        this.repository.delete(saved.getStockNum());
        d_getAll();
    }


}
