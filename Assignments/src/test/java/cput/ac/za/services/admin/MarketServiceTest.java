package cput.ac.za.services.admin;

import cput.ac.za.domain.admin.Market;
import cput.ac.za.factory.admin.MarketFactory;
import cput.ac.za.repository.admin.impl.MarketRepImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MarketServiceTest {


    private MarketRepImpl repository;
    private Market market;

    private Market getSavedName(){
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = MarketRepImpl.getRepository();
        this.market = MarketFactory.getMarketNum("Market Number");
    }

    @Test
    public void a_create() {
        Market created = this.repository.create(this.market);
        System.out.println("created : " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.market);
    }

    @Test
    public void b_read() {
        Market saved = getSavedName();
        Market read = this.repository.read(saved.getMarketNum());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void c_update() {
        String newName = "New Number";
        Market updated = new Market.Builder().copy(getSavedName()).market(newName).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newName, updated.getMarketNum());
    }

    @Test
    public void d_getAll() {
        Set<Market> market = this.repository.getAll();
        System.out.println("all = " + market);
    }

    @Test
    public void e_delete() {
        Market saved = getSavedName();
        this.repository.delete(saved.getMarketNum());
        d_getAll();
    }

}
