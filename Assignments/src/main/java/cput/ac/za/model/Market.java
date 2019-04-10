package cput.ac.za.model;


public class Market {

    private String marketID;
    private String marketName;

    private Market(){}

    private Market(Builder builder){
        this.marketID = builder.marketID;
        this.marketName = builder.marketName;
    }

    public String getMarketID() {
        return marketID;
    }

    public String getMarketName() {
        return marketName;
    }

    public static class Builder{

        private String marketID;
        private String marketName;

        public Builder marketID(String marketID){
            this.marketID = marketID;
            return this;
        }

        public Builder marketName(String marketName){
            this.marketName = marketName;
            return this;
        }

        public Market build() {
            return new Market(this);
        }

        @Override
        public String toString() {
            return "Market ID :" + marketID + "\nMarket Name :" + marketName;
        }




    }
}
