package cput.ac.za.factory;

import cput.ac.za.model.Market;
import cput.ac.za.repository.marketIDGenerate;

public class MarketFactory {
    public static Market getMarket(String marketID) {
        return new Market.Builder().marketID(marketIDGenerate.generateId())
                .marketID(marketID)
                .build();
    }
}
