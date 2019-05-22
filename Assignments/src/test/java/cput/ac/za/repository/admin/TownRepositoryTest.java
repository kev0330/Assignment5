package cput.ac.za.repository.admin;

import cput.ac.za.domain.admin.Item;
import cput.ac.za.domain.admin.Town;
import cput.ac.za.factory.admin.TownFactory;

import cput.ac.za.repository.admin.impl.TownRepImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.IOException;
import java.util.Set;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TownRepositoryTest {

    private Town town;
    private TownRepository repository;


    private Town getSaved() {
        Set<Town> saved = this.repository.getAll();
        return saved.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = TownRepImpl.getRepository();
        this.town = TownFactory.getTownName("Town Name");
    }

    @Test
    public void a_create() throws IOException {
        Town town = this.repository.create(this.town);
        Assert.assertSame(town, this.town);
        System.out.println("Create = " + town);
        d_getAll();
    }

    @Test
    public void b_read(){
        Town saved = getSaved();
        System.out.println("In read, cityName = " + saved.getTownName());
        Town read = this.repository.read(saved.getTownName());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(saved, read);

    }

    @Test
    public void c_update() {
        String newNum = "New Number";
        Town town = new Town.Builder().copy(getSaved()).townName(newNum).build();
        System.out.println("In update, about_to_updated = " + town);
        Town updated = this.repository.update(town);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newNum, updated.getTownName());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Town> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);

    }

    @Test
    public void e_delete() {
        Town saved = getSaved();
        this.repository.delete(saved.getTownName());
        d_getAll();
    }


}
