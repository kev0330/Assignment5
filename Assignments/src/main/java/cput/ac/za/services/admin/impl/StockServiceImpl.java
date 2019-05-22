package cput.ac.za.services.admin.impl;

import cput.ac.za.domain.admin.Stock;
import cput.ac.za.repository.admin.StockRepository;
import cput.ac.za.repository.admin.impl.StockRepImpl;
import cput.ac.za.services.admin.StockService;

import java.util.Set;

public class StockServiceImpl implements StockService {

    private static StockServiceImpl service = null;
    private StockRepository repository;

    private StockServiceImpl() {
        this.repository = StockRepImpl.getRepository();
    }

    public static StockServiceImpl getService(){
        if (service == null) service = new StockServiceImpl();
        return service;
    }

    @Override
    public Stock create(Stock stock) {
        return this.repository.create(stock);
    }

    @Override
    public Stock update(Stock stock) {
        return this.repository.update(stock);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Stock read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Stock> getAll() {
        return this.repository.getAll();
    }
}
