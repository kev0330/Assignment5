package cput.ac.za.domain.admin;


public class Stock {

    private String stockNum;

    private Stock(){}

    private Stock(Builder builder){
        this.stockNum = builder.stockNum;

    }

    public String getStockNum() {
        return stockNum;
    }

    public static class Builder{

        private String stockNum;

        public Builder Stock(String stockNum){
            this.stockNum = stockNum;
            return this;
        }

        public Stock.Builder copy(Stock stock){
            this.stockNum = stock.stockNum;
            return this;
        }

        public Stock build() {
            return new Stock(this);
        }



    }
    @Override
    public String toString() {
        return "Stock :" + stockNum;
    }



}
