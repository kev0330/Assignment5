package cput.ac.za.factory;

import cput.ac.za.model.Employee;

public class EmployeeFactory {
    
    public static Employee getEmployeeID(int employeeID) {
        return new Employee.Builder().employeeID(employeeID)
                .build();
    }

}   

