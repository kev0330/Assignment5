package cput.ac.za.model;


public class Employee {

    private int employeeID;

    private Employee(){}

    private Employee(Builder builder){
        this.employeeID = builder.employeeID;

    }

    public int getEmployeeID() {
        return employeeID;
    }

    public static class Builder{

        private int employeeID;

        public Builder Employee(int employeeID){
            this.employeeID = employeeID;
            return this;
        }

        public Employee build() {
            return new Employee(this);
        }

        @Override
        public String toString() {
            return "Employee :" + employeeID;
        }




    }
}
