package cput.ac.za.services;

public interface IService <T, X>{

    T create(T type);

    T update(T type);

    void delete(X Y);

    T read(X Y);
}
