package cput.ac.za.repository.admin;

import static org.junit.Assert.assertTrue;

import cput.ac.za.domain.admin.City;
import cput.ac.za.factory.admin.CityFactory;
import cput.ac.za.repository.admin.CityRepository;
import cput.ac.za.repository.admin.impl.CityRepImpl;
import org.junit.Assert;
import org.junit.Before;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.IOException;
import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CityRepositoryTest
{
    private City city;
    private CityRepository repository;


    private City getSavedCity() {
        Set<City> savedCity = this.repository.getAll();
        return savedCity.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = CityRepImpl.getRepository();
        this.city = CityFactory.getCityName("Test CityName");
    }

    @Test
    public void a_create() throws IOException {
        City cityName = this.repository.create(this.city);
        Assert.assertSame(cityName, this.city);
        System.out.println("Create = " + cityName);
        d_getAll();
    }

    @Test
    public void b_read(){
        City savedCity = getSavedCity();
        System.out.print("In read = " + savedCity.getCityName());
        City read = this.repository.read(savedCity.getCityName());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedCity, read);

    }

    @Test
    public void c_update() {
        String newName = "New City Name";
        City city = new City.Builder().copy(getSavedCity()).cityName(newName).build();
        System.out.println("In update, about_to_updated = " + city);
        City updated = this.repository.update(city);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newName, updated.getCityName());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<City> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);

    }

    @Test
    public void e_delete() {
        City savedCity = getSavedCity();
        this.repository.delete(savedCity.getCityName());
        d_getAll();
    }


    
    
}
