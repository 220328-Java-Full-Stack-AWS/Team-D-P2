package com.revature.GroupDP2.Irepository;

import java.util.List;
import java.util.Optional;

public interface IGenericRepository<T> {
    void create(T t);
    void update(T t);
    Optional<T> getById(int t);
    List<T>getAll();
    void delete(T t);
}
