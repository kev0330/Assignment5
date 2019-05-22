package cput.ac.za.repository.admin;


import cput.ac.za.domain.admin.Street;
import cput.ac.za.factory.admin.StreetFactory;
import cput.ac.za.repository.admin.impl.StreetRepImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.IOException;
import java.util.Set;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StreetRepositoryTest {

    private Street street;
    private StreetRepository repository;


    private Street getSaved() {
        Set<Street> saved = this.repository.getAll();
        return saved.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = StreetRepImpl.getRepository();
        this.street = StreetFactory.getStreetNum("Street Number");
    }

    @Test
    public void a_create() throws IOException {
        Street street = this.repository.create(this.street);
        Assert.assertSame(street, this.street);
        System.out.println("Create = " + street);
        d_getAll();
    }

    @Test
    public void b_read(){
        Street saved = getSaved();
        System.out.println("In read, cityName = " + saved.getStreetNum());
        Street read = this.repository.read(saved.getStreetNum());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(saved, read);

    }

    @Test
    public void c_update() {
        String newNum = "New Number";
        Street street = new Street.Builder().copy(getSaved()).streetNum(newNum).build();
        System.out.println("In update, about_to_updated = " + street);
        Street updated = this.repository.update(street);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newNum, updated.getStreetNum());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Street> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);

    }

    @Test
    public void e_delete() {
        Street saved = getSaved();
        this.repository.delete(saved.getStreetNum());
        d_getAll();
    }


}
