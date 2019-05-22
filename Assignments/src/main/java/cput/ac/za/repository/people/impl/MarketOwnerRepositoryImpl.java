package cput.ac.za.repository.people.impl;


import cput.ac.za.domain.people.MarketOwner;
import cput.ac.za.repository.admin.impl.ItemRepImpl;
import cput.ac.za.repository.people.MarketOwnerRepository;

import java.util.HashSet;
import java.util.Set;

public class MarketOwnerRepositoryImpl implements MarketOwnerRepository {

    private static MarketOwnerRepositoryImpl repository = null;
    private Set<MarketOwner> marketOwners;

    private MarketOwnerRepositoryImpl(){
        this.marketOwners = new HashSet<>();
    }

    private MarketOwner find(String a) {
        return this.marketOwners.stream()
                .filter(id -> id.getMarketOwnerID().equals(a))
                .findAny()
                .orElse(null);
    }

    public static MarketOwnerRepositoryImpl getRepository(){
        if(repository == null) repository = new MarketOwnerRepositoryImpl();
        return repository;
    }

    public MarketOwner create(MarketOwner marketOwners){
        this.marketOwners.add(marketOwners);
        return marketOwners;
    }

    public MarketOwner read(final String marketOwners){
        MarketOwner item = find(marketOwners);
        return item;
    }

    public void delete(String marketOwner) {
        MarketOwner marketOwners = find(marketOwner);
        if(marketOwners != null) this.marketOwners.remove(marketOwners);
    }

    public MarketOwner update(MarketOwner marketOwners) {
        MarketOwner delete = find(marketOwners.getMarketOwnerID());
        if(delete != null){
            this.marketOwners.remove(delete);
            return create(marketOwners);
        }
        return marketOwners;
    }

    public Set<MarketOwner> getAll(){
        return this.marketOwners;
    }
}
