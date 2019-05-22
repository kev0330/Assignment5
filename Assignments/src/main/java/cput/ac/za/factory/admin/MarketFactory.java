package cput.ac.za.factory.admin;

import cput.ac.za.domain.admin.Market;

public class MarketFactory {
    
    public static Market getMarketNum(String marketNum) {
        return new Market.Builder().market(marketNum)
                .build();
    }

}
