package cput.ac.za.repository.people;

import cput.ac.za.domain.people.MarketOwner;
import cput.ac.za.repository.IRepository;

import java.util.Set;

public interface MarketOwnerRepository extends IRepository<MarketOwner, String> {
    Set<MarketOwner> getAll();
}
