package cput.ac.za.repository.admin.impl;

import cput.ac.za.domain.admin.Market;
import cput.ac.za.domain.admin.Town;
import cput.ac.za.repository.admin.TownRepository;

import java.util.HashSet;
import java.util.Set;

public class TownRepImpl implements TownRepository {
    private static TownRepImpl repository = null;
    private Set<Town> towns;

    private TownRepImpl(){
        this.towns = new HashSet<>();
    }

    private Town find(String town) {
        return this.towns.stream()
                .filter(towns -> towns.getTownName().equals(town))
                .findAny()
                .orElse(null);
    }

    public static TownRepImpl getRepository(){
        if(repository == null) repository = new TownRepImpl();
        return repository;
    }

    public Town create(Town town){
        this.towns.add(town);
        return town;
    }

    public Town read(final String town){
        Town towns = find(town);
        return towns;
    }

    public void delete(String town) {
        Town towns = find(town);
        if(towns != null) this.towns.remove(towns);
    }

    public Town update(Town town) {
        Town delete = find(town.getTownName());
        if(delete != null){
            this.towns.remove(delete);
            return create(town);
        }
        return town;
    }

    public Set<Town> getAll(){
        return this.towns;
    }
}
