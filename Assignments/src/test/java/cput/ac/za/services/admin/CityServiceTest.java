package cput.ac.za.services.admin;

import cput.ac.za.domain.admin.City;
import cput.ac.za.factory.admin.CityFactory;
import cput.ac.za.repository.admin.impl.CityRepImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CityServiceTest {

    private CityRepImpl repository;
    private City city;

    private City getSavedName(){
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = CityRepImpl.getRepository();
        this.city = CityFactory.getCityName("CITY NAME");
    }

    @Test
    public void a_create() {
        City created = this.repository.create(this.city);
        System.out.println("created : " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.city);
    }

    @Test
    public void b_read() {
        City saved = getSavedName();
        City read = this.repository.read(saved.getCityName());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void c_update() {
        String newName = "New Name";
        City updated = new City.Builder().copy(getSavedName()).cityName(newName).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newName, updated.getCityName());
    }

    @Test
    public void d_getAll() {
        Set<City> city = this.repository.getAll();
        System.out.println("all = " + city);
    }

    @Test
    public void e_delete() {
        City saved = getSavedName();
        this.repository.delete(saved.getCityName());
        d_getAll();
    }

}
