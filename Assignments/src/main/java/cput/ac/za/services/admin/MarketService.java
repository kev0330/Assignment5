package cput.ac.za.services.admin;

import cput.ac.za.domain.admin.Market;
import cput.ac.za.services.IService;

import java.util.Set;

public interface MarketService extends IService<Market, String> {
    Set<Market> getAll();
}
