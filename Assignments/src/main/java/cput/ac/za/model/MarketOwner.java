package cput.ac.za.model;


public class MarketOwner {

    private int marketOwnerID;

    private MarketOwner(){}

    private MarketOwner(Builder builder){
        this.marketOwnerID = builder.marketOwnerID;

    }

    public int getMarketOwnerID() {
        return marketOwnerID;
    }

    public static class Builder{

        private int marketOwnerID;

        public Builder MarketOwner(int marketOwnerID){
            this.marketOwnerID = marketOwnerID;
            return this;
        }

        public MarketOwner build() {
            return new MarketOwner(this);
        }

        @Override
        public String toString() {
            return "Market Owner :" + marketOwnerID;
        }




    }
}
