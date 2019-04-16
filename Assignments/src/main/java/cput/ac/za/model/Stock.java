package cput.ac.za.model;


public class Stock {

    private int stockNum;

    private Stock(){}

    private Stock(Builder builder){
        this.stockNum = builder.stockNum;

    }

    public int getStockNum() {
        return stockNum;
    }

    public static class Builder{

        private int stockNum;

        public Builder Storage(int stockNum){
            this.stockNum = stockNum;
            return this;
        }

        public Stock build() {
            return new Stock(this);
        }

        @Override
        public String toString() {
            return "Stock :" + stockNum;
        }




    }
}
