package cput.ac.za.factory.people;

import cput.ac.za.domain.people.Employee;

public class EmployeeFactory {
    
    public static Employee getEmployeeID(String employeeID) {
        return new Employee.Builder().Employee(employeeID)
                .build();
    }

}   

