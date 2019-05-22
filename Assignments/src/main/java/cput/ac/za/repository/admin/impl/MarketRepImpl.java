package cput.ac.za.repository.admin.impl;

import cput.ac.za.domain.admin.Market;
import cput.ac.za.repository.admin.MarketRepository;

import java.util.HashSet;
import java.util.Set;

public class MarketRepImpl implements MarketRepository {

    private static MarketRepImpl repository = null;
    private Set<Market> markets;

    private MarketRepImpl(){
        this.markets = new HashSet<>();
    }

    private Market find(String market) {
        return this.markets.stream()
                .filter(markets -> markets.getMarketNum().equals(market))
                .findAny()
                .orElse(null);
    }

    public static MarketRepImpl getRepository(){
        if(repository == null) repository = new MarketRepImpl();
        return repository;
    }

    public Market create(Market market){
        this.markets.add(market);
        return market;
    }

    public Market read(final String marketNum){
        Market market = find(marketNum);
        return market;
    }

    public void delete(String marketNum) {
        Market market = find(marketNum);
        if(market != null) this.markets.remove(market);
    }

    public Market update(Market market) {
        Market delete = find(market.getMarketNum());
        if(delete != null){
            this.markets.remove(delete);
            return create(market);
        }
        return market;
    }

    public Set<Market> getAll(){
        return this.markets;
    }
}
