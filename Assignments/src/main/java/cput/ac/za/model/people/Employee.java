package cput.ac.za.domain.people;


public class Employee {

    private String employeeID;

    private Employee(){}

    private Employee(Builder builder){
        this.employeeID = builder.employeeID;

    }

    public String getEmployeeID() {
        return employeeID;
    }

    public static class Builder{

        private String employeeID;

        public Builder Employee(String employeeID){
            this.employeeID = employeeID;
            return this;
        }

        public Employee.Builder copy(Employee employee){
            this.employeeID = employee.employeeID;
            return this;
        }

        public Employee build() {
            return new Employee(this);
        }






    }
    @Override
    public String toString() {
        return "Employee :" + employeeID;
    }
}
