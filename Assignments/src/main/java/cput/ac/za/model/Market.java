package cput.ac.za.domain.admin;


public class Market {

    private String marketNum;

    private Market(){}

    private Market(Builder builder){
        this.marketNum = builder.marketNum;
    }

    public String getMarketNum() {
        return marketNum;
    }

    public static class Builder{

        private String marketNum;

        public Builder market(String marketNum){
            this.marketNum = marketNum;
            return this;
        }

        public Market.Builder copy(Market market){
            this.marketNum = market.marketNum;
            return this;
        }

        public Market build() {
            return new Market(this);
        }





    }

    @Override
    public String toString() {
        return "Market ID :" + marketNum;
    }

}
