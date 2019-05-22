package cput.ac.za.services.admin;

import cput.ac.za.domain.admin.Town;
import cput.ac.za.factory.admin.TownFactory;
import cput.ac.za.repository.admin.impl.TownRepImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TownServiceTest {

    private TownRepImpl repository;
    private Town town;

    private Town getSavedName(){
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = TownRepImpl.getRepository();
        this.town = TownFactory.getTownName("Town name");
    }

    @Test
    public void a_create() {
        Town created = this.repository.create(this.town);
        System.out.println("created : " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.town);
    }

    @Test
    public void b_read() {
        Town saved = getSavedName();
        Town read = this.repository.read(saved.getTownName());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void c_update() {
        String newName = "New Name";
        Town updated = new Town.Builder().copy(getSavedName()).townName(newName).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newName, updated.getTownName());
    }

    @Test
    public void d_getAll() {
        Set<Town> town = this.repository.getAll();
        System.out.println("all = " + town);
    }

    @Test
    public void e_delete() {
        Town saved = getSavedName();
        this.repository.delete(saved.getTownName());
        d_getAll();
    }

}
