package cput.ac.za.services.admin;

import cput.ac.za.domain.admin.Stock;
import cput.ac.za.services.IService;

import java.util.Set;

public interface StockService extends IService<Stock, String> {
    Set<Stock> getAll();
}
