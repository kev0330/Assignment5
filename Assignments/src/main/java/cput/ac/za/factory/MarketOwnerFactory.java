package cput.ac.za.factory;

import cput.ac.za.model.MarketOwner;


public class MarketOwnerFactory {
    
    
    public static MarketOwner getMarketOwnerID(int marketOwnerID) {
        return new MarketOwner.Builder().marketOwnerID(marketOwnerID)
                .build();
    }

}   
