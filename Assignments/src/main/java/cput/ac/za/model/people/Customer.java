package cput.ac.za.domain.people;




public class Customer {

    private String customerID;

    private Customer(){}

    private Customer(Builder builder){
        this.customerID = builder.customerID;

    }

    public String getCustomerID() {
        return customerID;
    }

    public static class Builder{

        private String customerID;

        public Builder Customer(String customerID){
            this.customerID = customerID;
            return this;
        }

        public Customer.Builder copy(Customer customer){
            this.customerID = customer.customerID;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }





    }
    @Override
    public String toString() {
        return "Customer :" + customerID;
    }

}