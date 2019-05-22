package cput.ac.za.domain.admin;


public class Store {

    private String storeNum;

    private Store(){}

    private Store(Builder builder){
        this.storeNum = builder.storeNum;

    }

    public String getStoreNum() {
        return storeNum;
    }

    public static class Builder{

        private String storeNum;

        public Builder Store(String storeNum){
            this.storeNum = storeNum;
            return this;
        }

        public Store.Builder copy(Store store){
            this.storeNum = store.storeNum;
            return this;
        }

        public Store build() {
            return new Store(this);
        }





    }
    @Override
    public String toString() {
        return "Store :" + storeNum;
    }

}
