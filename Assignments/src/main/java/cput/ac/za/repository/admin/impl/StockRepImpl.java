package cput.ac.za.repository.admin.impl;


import cput.ac.za.domain.admin.Stock;
import cput.ac.za.repository.admin.StockRepository;

import java.util.HashSet;
import java.util.Set;

public class StockRepImpl implements StockRepository {
    private static StockRepImpl repository = null;
    private Set<Stock> stocks;

    private StockRepImpl(){
        this.stocks = new HashSet<>();
    }

    private Stock find(String stocks) {
        return this.stocks.stream()
                .filter(stock -> stock.getStockNum().equals(stocks))
                .findAny()
                .orElse(null);
    }

    public static StockRepImpl getRepository(){
        if(repository == null) repository = new StockRepImpl();
        return repository;
    }

    public Stock create(Stock stock){
        this.stocks.add(stock);
        return stock;
    }

    public Stock read(final String stocknum){
        Stock stock = find(stocknum);
        return stock;
    }

    public void delete(String stocknum) {
        Stock stock = find(stocknum);
        if(stock != null) this.stocks.remove(stock);
    }

    public Stock update(Stock stock) {
        Stock delete = find(stock.getStockNum());
        if(delete != null){
            this.stocks.remove(delete);
            return create(stock);
        }
        return stock;
    }

    public Set<Stock> getAll(){
        return this.stocks;
    }
}
