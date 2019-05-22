package cput.ac.za.domain.people;


public class Supplier {

    private String supplierID;

    private Supplier(){}

    private Supplier(Builder builder){
        this.supplierID = builder.supplierID;

    }

    public String getSupplierID() {
        return supplierID;
    }

    public static class Builder{

        private String supplierID;

        public Builder Supplier(String supplierID){
            this.supplierID = supplierID;
            return this;
        }

        public Supplier.Builder copy(Supplier supplier){
            this.supplierID = supplier.supplierID;
            return this;
        }

        public Supplier build() {
            return new Supplier(this);
        }






    }
    @Override
    public String toString() {
        return "Supplier :" + supplierID;
    }
}
