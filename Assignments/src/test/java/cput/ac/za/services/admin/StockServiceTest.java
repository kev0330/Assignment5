package cput.ac.za.services.admin;

import cput.ac.za.domain.admin.Stock;
import cput.ac.za.factory.admin.StockFactory;
import cput.ac.za.repository.admin.impl.StockRepImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StockServiceTest {

    private StockRepImpl repository;
    private Stock stock;

    private Stock getSavedName(){
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = StockRepImpl.getRepository();
        this.stock = StockFactory.getStockNum("Stock Number");
    }

    @Test
    public void a_create() {
        Stock created = this.repository.create(this.stock);
        System.out.println("created : " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.stock);
    }

    @Test
    public void b_read() {
        Stock saved = getSavedName();
        Stock read = this.repository.read(saved.getStockNum());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void c_update() {
        String newName = "New Number";
        Stock updated = new Stock.Builder().copy(getSavedName()).Stock(newName).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newName, updated.getStockNum());
    }

    @Test
    public void d_getAll() {
        Set<Stock> stock = this.repository.getAll();
        System.out.println("all = " + stock);
    }

    @Test
    public void e_delete() {
        Stock saved = getSavedName();
        this.repository.delete(saved.getStockNum());
        d_getAll();
    }

}

