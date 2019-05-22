package cput.ac.za.factory.people;

import cput.ac.za.domain.people.MarketOwner;


public class MarketOwnerFactory {
    
    
    public static MarketOwner getMarketOwnerID(String marketOwnerID) {
        return new MarketOwner.Builder().MarketOwner(marketOwnerID)
                .build();
    }

}   
