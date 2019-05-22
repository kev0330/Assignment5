package cput.ac.za.repository.people;


import cput.ac.za.domain.people.MarketOwner;
import cput.ac.za.factory.people.MarketOwnerFactory;

import cput.ac.za.repository.people.impl.MarketOwnerRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.IOException;
import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MarketOwnerRepTest {

    private MarketOwner marketOwner;
    private MarketOwnerRepository repository;


    private MarketOwner getSaved() {
        Set<MarketOwner> saved = this.repository.getAll();
        return saved.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = MarketOwnerRepositoryImpl.getRepository();
        this.marketOwner = MarketOwnerFactory.getMarketOwnerID("MarketOwner ID");
    }

    @Test
    public void a_create() throws IOException {
        MarketOwner item = this.repository.create(this.marketOwner);
        Assert.assertSame(item, this.marketOwner);
        System.out.println("Create = " + item);
        d_getAll();
    }

    @Test
    public void b_read(){
        MarketOwner saved = getSaved();
        System.out.println("In read  = " + saved.getMarketOwnerID());
        MarketOwner read = this.repository.read(saved.getMarketOwnerID());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(saved, read);

    }

    @Test
    public void c_update() {
        String newNum = "New ID";
        MarketOwner item = new MarketOwner.Builder().copy(getSaved()).MarketOwner(newNum).build();
        System.out.println("In update, about_to_updated = " + item);
        MarketOwner updated = this.repository.update(item);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newNum, updated.getMarketOwnerID());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<MarketOwner> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);

    }

    @Test
    public void e_delete() {
        MarketOwner saved = getSaved();
        this.repository.delete(saved.getMarketOwnerID());
        d_getAll();
    }
}
