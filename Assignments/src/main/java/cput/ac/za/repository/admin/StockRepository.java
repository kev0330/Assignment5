package cput.ac.za.repository.admin;

import cput.ac.za.domain.admin.Stock;
import cput.ac.za.repository.IRepository;

import java.util.Set;

public interface StockRepository  extends IRepository<Stock, String> {
    Set<Stock> getAll();
}
