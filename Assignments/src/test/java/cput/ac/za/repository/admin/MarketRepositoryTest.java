package cput.ac.za.repository.admin;


import cput.ac.za.domain.admin.Market;
import cput.ac.za.factory.admin.MarketFactory;
import cput.ac.za.repository.admin.impl.ItemRepImpl;
import cput.ac.za.repository.admin.impl.MarketRepImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.IOException;
import java.util.Set;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MarketRepositoryTest {

    private Market market;
    private MarketRepository repository;


    private Market getSaved() {
        Set<Market> saved = this.repository.getAll();
        return saved.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = MarketRepImpl.getRepository();
        this.market = MarketFactory.getMarketNum("Market Number");
    }

    @Test
    public void a_create() throws IOException {
        Market market = this.repository.create(this.market);
        Assert.assertSame(market, this.market);
        System.out.println("Create = " + market);
        d_getAll();
    }

    @Test
    public void b_read(){
        Market saved = getSaved();
        System.out.println("In read, cityName = " + saved.getMarketNum());
        Market read = this.repository.read(saved.getMarketNum());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(saved, read);

    }

    @Test
    public void c_update() {
        String newNum = "New Number";
        Market market = new Market.Builder().copy(getSaved()).market(newNum).build();
        System.out.println("In update, about_to_updated = " + market);
        Market updated = this.repository.update(market);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newNum, updated.getMarketNum());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Market> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);

    }

    @Test
    public void e_delete() {
        Market saved = getSaved();
        this.repository.delete(saved.getMarketNum());
        d_getAll();
    }


}
