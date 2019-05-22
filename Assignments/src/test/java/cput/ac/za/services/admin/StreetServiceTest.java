package cput.ac.za.services.admin;

import cput.ac.za.domain.admin.Street;
import cput.ac.za.factory.admin.StreetFactory;
import cput.ac.za.repository.admin.impl.StreetRepImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StreetServiceTest {

    private StreetRepImpl repository;
    private Street street;

    private Street getSavedName(){
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = StreetRepImpl.getRepository();
        this.street = StreetFactory.getStreetNum("Street");
    }

    @Test
    public void a_create() {
        Street created = this.repository.create(this.street);
        System.out.println("created : " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.street);
    }

    @Test
    public void b_read() {
        Street saved = getSavedName();
        Street read = this.repository.read(saved.getStreetNum());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void c_update() {
        String newName = "New Number";
        Street updated = new Street.Builder().copy(getSavedName()).streetNum(newName).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newName, updated.getStreetNum());
    }

    @Test
    public void d_getAll() {
        Set<Street> city = this.repository.getAll();
        System.out.println("all = " + city);
    }

    @Test
    public void e_delete() {
        Street saved = getSavedName();
        this.repository.delete(saved.getStreetNum());
        d_getAll();
    }

}
