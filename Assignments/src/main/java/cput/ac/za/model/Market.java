package cput.ac.za.model;


public class Market {

    private String marketNum;

    private Market(){}

    private Market(Builder builder){
        this.marketNum = builder.marketNum;
    }

    public String getMarketID() {
        return marketNum;
    }

    public static class Builder{

        private String marketNum;

        public Builder marketNum(String marketNum){
            this.marketNum = marketNum;
            return this;
        }


        public Market build() {
            return new Market(this);
        }

        @Override
        public String toString() {
            return "Market ID :" + marketNum;
        }




    }
}
