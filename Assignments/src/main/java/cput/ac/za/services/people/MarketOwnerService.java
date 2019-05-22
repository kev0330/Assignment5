package cput.ac.za.services.people;

import cput.ac.za.domain.people.MarketOwner;
import cput.ac.za.services.IService;

import java.util.Set;

public interface MarketOwnerService extends IService<MarketOwner, String> {
    Set<MarketOwner> getAll();
}
