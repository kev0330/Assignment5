package cput.ac.za.domain.people;


public class MarketOwner {

    private String marketOwnerID;

    private MarketOwner(){}

    private MarketOwner(Builder builder){
        this.marketOwnerID = builder.marketOwnerID;

    }

    public String getMarketOwnerID() {
        return marketOwnerID;
    }

    public static class Builder{

        private String marketOwnerID;

        public Builder MarketOwner(String marketOwnerID){
            this.marketOwnerID = marketOwnerID;
            return this;
        }

        public MarketOwner.Builder copy(MarketOwner marketOwner){
            this.marketOwnerID = marketOwner.marketOwnerID;
            return this;
        }

        public MarketOwner build() {
            return new MarketOwner(this);
        }






    }
    @Override
    public String toString() {
        return "Market Owner :" + marketOwnerID;
    }
}
