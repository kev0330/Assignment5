package cput.ac.za.factory;

import cput.ac.za.model.Market;
import cput.ac.za.repository.marketIDGenerate;

public class MarketFactory {
    
    public static Market getMarketNum(int marketNum) {
        return new Market.Builder().marketNum(marketNum)
                .build();
    }

}
