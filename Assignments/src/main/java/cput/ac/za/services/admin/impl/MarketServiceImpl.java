package cput.ac.za.services.admin.impl;

import cput.ac.za.domain.admin.Market;
import cput.ac.za.repository.admin.MarketRepository;
import cput.ac.za.repository.admin.impl.MarketRepImpl;
import cput.ac.za.services.admin.MarketService;

import java.util.Set;

public class MarketServiceImpl implements MarketService {

    private static MarketServiceImpl service = null;
    private MarketRepository repository;

    private MarketServiceImpl() {
        this.repository = MarketRepImpl.getRepository();
    }

    public static MarketServiceImpl getService(){
        if (service == null) service = new MarketServiceImpl();
        return service;
    }

    @Override
    public Market create(Market market) {
        return this.repository.create(market);
    }

    @Override
    public Market update(Market market) {
        return this.repository.update(market);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Market read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Market> getAll() {
        return this.repository.getAll();
    }
}
