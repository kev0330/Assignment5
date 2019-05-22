package cput.ac.za.repository;

public interface IRepository <T , X>{
    T create(T t);
    T update(T t);
    void delete(X Y);
    T read(X Y);
}
