package cput.ac.za.domain.people;


public class StoreOwner {

    private String storeOwnerID;

    private StoreOwner(){}

    private StoreOwner(Builder builder){
        this.storeOwnerID = builder.storeOwnerID;

    }

    public String getStoreOwnerID() {
        return storeOwnerID;
    }

    public static class Builder{

        private String storeOwnerID;

        public Builder StoreOwner(String storeOwnerID){
            this.storeOwnerID = storeOwnerID;
            return this;
        }

        public StoreOwner.Builder copy(StoreOwner storeOwner){
            this.storeOwnerID = storeOwner.storeOwnerID;
            return this;
        }

        public StoreOwner build() {
            return new StoreOwner(this);
        }






    }
    @Override
    public String toString() {
        return "Store Owner :" + storeOwnerID;
    }
}

