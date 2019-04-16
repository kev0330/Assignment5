package cput.ac.za.model;


public class StoreOwner {

    private int storeOwnerID;

    private StoreOwner(){}

    private StoreOwner(Builder builder){
        this.storeOwnerID = builder.storeOwnerID;

    }

    public int getStoreOwnerID() {
        return storeOwnerID;
    }

    public static class Builder{

        private int storeOwnerID;

        public Builder StoreOwner(int storeOwnerID){
            this.storeOwnerID = storeOwnerID;
            return this;
        }

        public StoreOwner build() {
            return new StoreOwner(this);
        }

        @Override
        public String toString() {
            return "Store Owner :" + storeOwnerID;
        }




    }
}
