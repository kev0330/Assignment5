package cput.ac.za.services.people;

import cput.ac.za.domain.people.MarketOwner;
import cput.ac.za.factory.people.MarketOwnerFactory;
import cput.ac.za.repository.people.impl.MarketOwnerRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MarketOwnerServiceTest {



    private MarketOwnerRepositoryImpl repository;
    private MarketOwner marketOwner;

    private MarketOwner getSavedName(){
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = MarketOwnerRepositoryImpl.getRepository();
        this.marketOwner = MarketOwnerFactory.getMarketOwnerID("MarketOwner ID");
    }

    @Test
    public void a_create() {
        MarketOwner created = this.repository.create(this.marketOwner);
        System.out.println("created : " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.marketOwner);
    }

    @Test
    public void b_read() {
        MarketOwner saved = getSavedName();
        MarketOwner read = this.repository.read(saved.getMarketOwnerID());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void c_update() {
        String newName = "New Number";
        MarketOwner updated = new MarketOwner.Builder().copy(getSavedName()).MarketOwner(newName).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newName, updated.getMarketOwnerID());
    }

    @Test
    public void d_getAll() {
        Set<MarketOwner> marketOwner = this.repository.getAll();
        System.out.println("all = " + marketOwner);
    }

    @Test
    public void e_delete() {
        MarketOwner saved = getSavedName();
        this.repository.delete(saved.getMarketOwnerID());
        d_getAll();
    }
}
