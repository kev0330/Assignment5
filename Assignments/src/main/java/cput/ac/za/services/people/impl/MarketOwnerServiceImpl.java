package cput.ac.za.services.people.impl;

import cput.ac.za.domain.admin.Market;
import cput.ac.za.domain.people.MarketOwner;
import cput.ac.za.repository.people.MarketOwnerRepository;
import cput.ac.za.repository.people.impl.MarketOwnerRepositoryImpl;
import cput.ac.za.services.people.MarketOwnerService;

import java.util.Set;

public class MarketOwnerServiceImpl implements MarketOwnerService {

    private static MarketOwnerServiceImpl service = null;
    private MarketOwnerRepository repository;

    private MarketOwnerServiceImpl() {
        this.repository = MarketOwnerRepositoryImpl.getRepository();
    }

    public static MarketOwnerServiceImpl getService(){
        if (service == null) service = new MarketOwnerServiceImpl();
        return service;
    }

    @Override
    public MarketOwner create(MarketOwner marketOwner) {
        return this.repository.create(marketOwner);
    }

    @Override
    public MarketOwner update(MarketOwner marketOwner) {
        return this.repository.update(marketOwner);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public MarketOwner read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<MarketOwner> getAll() {
        return this.repository.getAll();
    }
}
