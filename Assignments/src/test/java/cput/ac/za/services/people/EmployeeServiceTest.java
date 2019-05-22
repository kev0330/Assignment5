package cput.ac.za.services.people;

import cput.ac.za.domain.people.Employee;
import cput.ac.za.factory.people.EmployeeFactory;
import cput.ac.za.repository.people.impl.EmployeeRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeServiceTest {



    private EmployeeRepositoryImpl repository;
    private Employee employee;

    private Employee getSavedName(){
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = EmployeeRepositoryImpl.getRepository();
        this.employee = EmployeeFactory.getEmployeeID("Employee ID");
    }

    @Test
    public void a_create() {
        Employee created = this.repository.create(this.employee);
        System.out.println("created : " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.employee);
    }

    @Test
    public void b_read() {
        Employee saved = getSavedName();
        Employee read = this.repository.read(saved.getEmployeeID());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void c_update() {
        String newName = "New Number";
        Employee updated = new Employee.Builder().copy(getSavedName()).Employee(newName).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newName, updated.getEmployeeID());
    }

    @Test
    public void d_getAll() {
        Set<Employee> city = this.repository.getAll();
        System.out.println("all = " + city);
    }

    @Test
    public void e_delete() {
        Employee saved = getSavedName();
        this.repository.delete(saved.getEmployeeID());
        d_getAll();
    }
}

