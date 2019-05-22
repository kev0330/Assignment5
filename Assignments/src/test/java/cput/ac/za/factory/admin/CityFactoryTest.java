package cput.ac.za.factory.admin;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import cput.ac.za.domain.admin.City;
public class CityFactoryTest {

    private String testName;

    @Before
    public void setUp() throws Exception {
        this.testName = "testName";
    }

    @Test
    public void buildCourse() {
        City city = CityFactory.getCityName(this.testName);
        Assert.assertNotNull(city.getCityName());
        Assert.assertNotNull(city);
    }
}
