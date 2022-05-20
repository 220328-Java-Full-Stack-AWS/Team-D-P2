package com.revature.GroupDP2.repository;

import com.revature.GroupDP2.Irepository.IUserRepository;
import com.revature.GroupDP2.model.Cart;
import com.revature.GroupDP2.util.StorageManager;
import com.revature.GroupDP2.model.User;
import org.hibernate.Session;
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
    private Session session;


    @Autowired
    public UserRepository(StorageManager storageManager) {
        this.storageManager = storageManager;
    }


    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public void create(User o) {
        Transaction t = session.beginTransaction();
        session.save(o);
        t.commit();
    }

    @Override
    public void update(User o) {
        Transaction t = session.beginTransaction();
        session.update(o);
        t.commit();
    }

    @Override
    public Optional<User> getById(int t) {
        try {
            TypedQuery<User> query = session.createQuery("FROM User WHERE id= :id", User.class);
            query.setParameter("id", t);
            return Optional.ofNullable(query.getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

    @Override
    public void delete (User o){
        Transaction t = session.beginTransaction();
        session.delete(o);
        t.commit();
    }

    @Override
    public Optional<User> getByUsername (String username){
        try {
            TypedQuery<User> query = session.createQuery("FROM User WHERE userName= :userName", User.class);
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
        session = storageManager.getSession();
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