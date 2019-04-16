package cput.ac.za.model;


public class Store {

    private int storeNum;

    private Store(){}

    private Store(Builder builder){
        this.storeNum = builder.storeNum;

    }

    public int getStoreNum() {
        return storeNum;
    }

    public static class Builder{

        private int storeNum;

        public Builder Store(int storeNum){
            this.storeNum = storeNum;
            return this;
        }

        public Store build() {
            return new Store(this);
        }

        @Override
        public String toString() {
            return "Store :" + storeNum;
        }




    }
}
