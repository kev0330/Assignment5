package cput.ac.za.factory.admin;

import cput.ac.za.domain.admin.Stock;


public class StockFactory {
    
    
             public static Stock getStockNum(String stockNum) {
        return new Stock.Builder().Stock(stockNum)
                .build();
    }




}  