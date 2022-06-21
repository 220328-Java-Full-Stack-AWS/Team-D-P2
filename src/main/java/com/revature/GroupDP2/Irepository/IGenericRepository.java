package com.revature.GroupDP2.Irepository;

import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public interface IGenericRepository<T> {
    void create(T t, Session session);
    void update(T t,Session session);
    Optional<T> getById(int t,Session session);
    List<T>getAll(Session session);
    void delete(T t,Session session);
}
