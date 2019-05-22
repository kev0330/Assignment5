package cput.ac.za.repository.admin;

import cput.ac.za.domain.admin.Market;
import cput.ac.za.repository.IRepository;

import java.util.Set;

public interface MarketRepository  extends IRepository<Market, String> {
    Set<Market> getAll();
}
