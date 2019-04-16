package cput.ac.za.factory;

import cput.ac.za.model.Stock;


public class StockFactory {
    
    
             public static Stock getStockNum(int stockNum) {
        return new Stock.Builder().stockNum(stockNum)
                .build();
    }




}  