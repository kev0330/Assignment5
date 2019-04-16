package cput.ac.za.model;


public class Supplier {

    private int supplierID;

    private Supplier(){}

    private Supplier(Builder builder){
        this.supplierID = builder.supplierID;

    }

    public int getSupplierID() {
        return supplierID;
    }

    public static class Builder{

        private int supplierID;

        public Builder Supplier(int supplierID){
            this.supplierID = supplierID;
            return this;
        }

        public Supplier build() {
            return new Supplier(this);
        }

        @Override
        public String toString() {
            return "Supplier :" + supplierID;
        }




    }
}
