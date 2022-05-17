package com.revature.GroupDP2.repository;

import com.revature.GroupDP2.Irepository.IPaymentRepository;
import com.revature.GroupDP2.model.Payment;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import com.revature.GroupDP2.util.StorageManager;
import org.springframework.context.Lifecycle;
import org.springframework.stereotype.Component;
import javax.persistence.TypedQuery;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;


/*
    @Component indicates that an annotated class is a "component". Such classes are considered
    as candidates for auto-detection when using annotation-based configuration
    and classpath scanning.
*/

@Component
public class PaymentRepository implements IPaymentRepository<Payment>, Lifecycle {

    //the return type of isRunning() that check whether a component is currently running
    private boolean running = false;


    private final StorageManager storageManager;

    /*
        * Session is the main runtime interface between a Java application and Hibernate.
        * It is the central API class abstracting the notion of a persistence service.
        * The main function of the Session is to offer create, read, and delete operations
          for instances of mapped entity classes.
        * Instances may exist in one of three states:
            * transient:never persistent, not associated with any Session. Transient instances
              may be made persistent by calling save(),
              persist() or saveOrUpdate().
            * persistent: associated with a unique Session. Persistent instances may be made
              transient by calling delete(). Any instance returned by a get() or load() method
              is persistent.
            * detached: previously persistent, not associated with any Session. Detached instances
              may be made persistent by calling update(), saveOrUpdate(), lock(), or replicate().
     */
    private  Session session;
    
    String tableName;

    public PaymentRepository(StorageManager storageManager) {
        this.storageManager = storageManager;

    }

    /*
        * save() and persist() result in an SQL INSERT
    */
    @Override
    public void create(Payment payment) {
        /* A transaction is associated with a Session and is usually initiated
           by a call to Session.beginTransaction().
        */
        Transaction tx = session.beginTransaction();
        session.save(payment);
        tx.commit();
    }

    /*
        * update() or merge() results in an SQL UPDATE
    */
    @Override
    public void update(Payment payment) {
        Transaction tx = session.beginTransaction();
        session.update(payment);
        tx.commit();
    }


    @Override
    public Optional getById(int t) {
        TypedQuery<Payment> query = session.createQuery("FROM Payment WHERE id = :id",Payment.class);
        query.setParameter("id",t);
        return Optional.ofNullable(query.getSingleResult());
    }

    /*
        * delete() results in an SQL DELETE
    */
    @Override
    public void delete(Payment payment) {
        Transaction tx = session.beginTransaction();
        if(payment != null){
            session.delete(payment);
        }
        tx.commit();

    }

    @Override
    public Payment getPaymentByCardNumber(Payment payment) {
        if (session != null){
            TypedQuery<Payment> query = session.createQuery("FROM Payment WHERE cardNumber = :cardNumber",Payment.class);
            query.setParameter("cardNumber", payment.getCardNumber());
            payment = query.getSingleResult();
        }
        else{
            //throw an exception
        }
        return payment;
    }

    public List<Payment> getAll() {
        String sql = "SELECT * FROM payment";
        Query query = session.createNativeQuery(sql);

        List<Object[]> results = query.getResultList();

        List<Payment> paymentList = new LinkedList<>();
        for (Object[] result : results) {
            Payment payment = new Payment();
            payment.setId((Integer) result[0]);
            payment.setCardNumber((String) result[1]);
            payment.setExpirationDate((String) result[2]);
            payment.setCvvNumber((Integer) result[3]);
            paymentList.add(payment);
        }
        return paymentList;
    }


    public Payment getById(Integer id) {
        String hql = " FROM Payment WHERE id = :id";
        TypedQuery<Payment> query = session.createQuery(hql, Payment.class);

        query.setParameter("id", id);

        Payment payment = query.getSingleResult();

        return payment;
    }


    /*
           * Start this component.
           * Should not throw an exception if the component is already running.
           * In the case of a container, this will propagate the start signal to all
             components that apply.
       */
    @Override
    public void start() {
        running = true;
        this.session = storageManager.getSession();
    }

    /*
        * Stop this component
        * Should not throw an exception if the component is not running (not started yet).
	    * In the case of a container, this will propagate the stop signal to all components
	      that apply.
    */
    @Override
    public void stop() {
        running = false;
        this.session.close();
    }

    /* Check whether this component is currently running.
        * In the case of a container, this will return {@code true} only if
          components that apply are currently running.
        * @return whether the component is currently running
    */
    @Override
    public boolean isRunning() {
        return running;
    }


}

