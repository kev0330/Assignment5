package cput.ac.za.model;


public class Market {

    private String marketID;

    private Market(){}

    private Market(Builder builder){
        this.marketID = builder.marketID;
    }

    public String getMarketID() {
        return marketID;
    }

    public static class Builder{

        private String marketID;

        public Builder marketID(String marketID){
            this.marketID = marketID;
            return this;
        }


        public Market build() {
            return new Market(this);
        }

        @Override
        public String toString() {
            return "Market ID :" + marketID;
        }




    }
}
