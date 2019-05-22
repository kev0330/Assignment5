package cput.ac.za.repository.people;


import cput.ac.za.domain.people.Employee;
import cput.ac.za.factory.people.CustomerFactory;
import cput.ac.za.factory.people.EmployeeFactory;
import cput.ac.za.repository.people.impl.CustomerRepositoryImpl;
import cput.ac.za.repository.people.impl.EmployeeRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.IOException;
import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeRepTest {

    private Employee employee;
    private EmployeeRepository repository;


    private Employee getSaved() {
        Set<Employee> saved = this.repository.getAll();
        return saved.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = EmployeeRepositoryImpl.getRepository();
        this.employee = EmployeeFactory.getEmployeeID("Employee ID");
    }

    @Test
    public void a_create() throws IOException {
        Employee item = this.repository.create(this.employee);
        Assert.assertSame(item, this.employee);
        System.out.println("Create = " + item);
        d_getAll();
    }

    @Test
    public void b_read(){
        Employee saved = getSaved();
        System.out.println("In read  = " + saved.getEmployeeID());
        Employee read = this.repository.read(saved.getEmployeeID());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(saved, read);

    }

    @Test
    public void c_update() {
        String newNum = "New ID";
        Employee item = new Employee.Builder().copy(getSaved()).Employee(newNum).build();
        System.out.println("In update, about_to_updated = " + item);
        Employee updated = this.repository.update(item);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newNum, updated.getEmployeeID());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Employee> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);

    }

    @Test
    public void e_delete() {
        Employee saved = getSaved();
        this.repository.delete(saved.getEmployeeID());
        d_getAll();
    }
}
