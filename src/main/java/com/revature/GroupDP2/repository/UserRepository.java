package com.revature.GroupDP2.repository;

import com.revature.GroupDP2.Irepository.IUserRepository;
import com.revature.GroupDP2.model.Cart;
import com.revature.GroupDP2.util.StorageManager;
import com.revature.GroupDP2.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.Lifecycle;
import org.springframework.stereotype.Repository;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;



@Repository
public class UserRepository implements IUserRepository, Lifecycle {
    private boolean running;
    private final StorageManager storageManager;
    private SessionFactory sessionFactory;


    @Autowired
    public UserRepository(StorageManager storageManager) {
        this.storageManager = storageManager;
    }


    @Override
    public List<User> getAll() {
        Session s=sessionFactory.openSession();
        TypedQuery<User> query = s.createQuery("FROM User", User.class);
        s.close();
        return query.getResultList();
    }

    @Override
    public void create(User o) {
        Session s=sessionFactory.openSession();
        Transaction t = s.beginTransaction();
        s.save(o);
        s.close();
        t.commit();
    }

    @Override
    public void update(User o) {
        Session s=sessionFactory.openSession();
        Transaction t = s.beginTransaction();
        s.update(o);
        s.close();
        t.commit();
    }

    @Override
    public Optional<User> getById(int t) {
        try {
            Session s=sessionFactory.openSession();
            TypedQuery<User> query = s.createQuery("FROM User WHERE id= :id", User.class);
            s.close();
            query.setParameter("id", t);
            return Optional.ofNullable(query.getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

    @Override
    public void delete (User o){
        Session s=sessionFactory.openSession();
        Transaction t = s.beginTransaction();
        s.delete(o);
        s.close();
        t.commit();
    }

    @Override
    public Optional<User> getByUsername (String username){
        try {
            Session s=sessionFactory.openSession();
            TypedQuery<User> query = s.createQuery("FROM User WHERE userName= :userName", User.class);
            s.close();
            query.setParameter("userName", username);
            return Optional.ofNullable(query.getSingleResult());
        }
        catch (NoResultException e) {
            return Optional.empty();
        }
    }

    public void addCart(Integer cartId, Integer userId){
        Transaction transaction = session.beginTransaction();
        User user = session.get(User.class, userId);
        Cart cart = session.get(Cart.class, cartId);
        user.setCart(cart);
        session.merge(user);
        transaction.commit();
    }


    @Override
    public void start () {
        sessionFactory = storageManager.getSessionFactory();
        running = true;
    }

    @Override
    public void stop () {
        running = false;
    }

    @Override
    public boolean isRunning () {
        return running;
    }
}