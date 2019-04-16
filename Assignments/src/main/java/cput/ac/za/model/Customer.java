package cput.ac.za.model;


public class Customer {

    private int customerID;

    private Customer(){}

    private Customer(Builder builder){
        this.customerID = builder.customerID;

    }

    public int getCustomerID() {
        return customerID;
    }

    public static class Builder{

        private int customerID;

        public Builder Customer(int customerID){
            this.customerID = customerID;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }

        @Override
        public String toString() {
            return "Customer :" + customerID;
        }




    }
}