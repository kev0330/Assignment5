package cput.ac.za.repository.admin.impl;

import cput.ac.za.domain.admin.Street;
import cput.ac.za.repository.admin.StreetRepository;

import java.util.HashSet;
import java.util.Set;

public class StreetRepImpl implements StreetRepository {
    private static StreetRepImpl repository = null;
    private Set<Street> streets;

    private StreetRepImpl(){
        this.streets = new HashSet<>();
    }

    private Street find(String street) {
        return this.streets.stream()
                .filter(streets -> streets.getStreetNum().equals(street))
                .findAny()
                .orElse(null);
    }

    public static StreetRepImpl getRepository(){
        if(repository == null) repository = new StreetRepImpl();
        return repository;
    }

    public Street create(Street street){
        this.streets.add(street);
        return street;
    }

    public Street read(final String streetNum){
        Street street = find(streetNum);
        return street;
    }

    public void delete(String streetNum) {
        Street street = find(streetNum);
        if(street != null) this.streets.remove(street);
    }

    public Street update(Street street) {
        Street delete = find(street.getStreetNum());
        if(delete != null){
            this.streets.remove(delete);
            return create(street);
        }
        return street;
    }

    public Set<Street> getAll(){
        return this.streets;
    }
}
