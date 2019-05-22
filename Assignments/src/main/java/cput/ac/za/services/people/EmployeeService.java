package cput.ac.za.services.people;

import cput.ac.za.domain.people.Employee;
import cput.ac.za.services.IService;

import java.util.Set;

public interface EmployeeService extends IService<Employee, String> {
    Set<Employee> getAll();
}
