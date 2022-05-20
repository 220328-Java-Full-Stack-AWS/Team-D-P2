package com.revature.GroupDP2.repository;

import com.revature.GroupDP2.Irepository.ICartRepository;
import com.revature.GroupDP2.model.Cart;
import com.revature.GroupDP2.util.StorageManager;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.Lifecycle;
import org.springframework.stereotype.Repository;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Repository
public class CartRepository implements ICartRepository, Lifecycle {

    private StorageManager storageManager;
    private Session session;
    private boolean running=false;
    @Autowired
    public CartRepository(StorageManager storageManager) {
        this.storageManager = storageManager;
    }

    @Override
    public void create(Cart c) {
        System.out.println("create method" + this.session);
        Transaction transaction = session.beginTransaction();
        session.save(c);
        transaction.commit();
    }

    @Override
    public void update(Cart c) {
        Transaction transaction = session.beginTransaction();
        session.update(c);
        transaction.commit();
    }

    @Override
    public Optional<Cart> getById(int t) {
        TypedQuery<Cart> query = session.createQuery("FROM Cart WHERE id = :id",Cart.class);
        query.setParameter("id",t);
        return Optional.ofNullable(query.getSingleResult());
    }

    @Override
    public void delete(Cart c) {
        Transaction transaction = session.beginTransaction();
        session.delete(c);
        transaction.commit();
    }

    //NEED TO FINISH THIS METHOD
    @Override
    public List<Cart> getAll() {
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from Cart");
        return query.getResultList();
    }

    @Override
    public void start() {
        this.session =storageManager.getSession();
        running=true;
    }

    @Override
    public void stop() {
    running=false;
    session.close();
    }

    @Override
    public boolean isRunning() {
        return running;
    }
}
