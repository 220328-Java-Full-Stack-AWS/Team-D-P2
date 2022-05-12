package com.revature.GroupDP2.repository;

import com.revature.GroupDP2.Irepository.IGenericRepository;
import com.revature.GroupDP2.model.Payment;
import com.revature.GroupDP2.util.TransactionManager;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;


public class PaymentRepository implements IGenericRepository<Payment> {

    private final TransactionManager transactionManager;
    private final Session session;


    public PaymentRepository(TransactionManager transactionManager,Session session) {
        this.transactionManager = transactionManager;
        this.session =session;
    }

    @Override
    public void create(Payment payment) {
        Transaction tx = session.beginTransaction();
        System.out.println(payment);
        session.save(payment);
        tx.commit();
    }

    @Override
    public void update(Payment payment) {
        Transaction tx = session.beginTransaction();
        session.update(payment);
        tx.commit();
    }

    @Override
    public Optional<Payment> getById(int t) {
        TypedQuery<Payment> query = session.createQuery("FROM Payment WHERE id= :id",Payment.class);
        query.setParameter("id",t);
        return Optional.ofNullable(query.getSingleResult());
    }


    public List<Payment> getAll() {
        String sql = "SELECT * FROM payment";
        Query query = session.createNativeQuery(sql);

        List<Object[]> results = query.getResultList();

        List<Payment> paymentList = new LinkedList<>();
        for(Object[] result : results) {
            Payment payment = new Payment();
            payment.setId((Integer)result[0]);
            payment.setCardNumber((String) result[1]);
            payment.setExpirationDate((String)result[2]);
            payment.setCvvNumber((Integer) result[3]);
            paymentList.add(payment);
        }
        return paymentList;
    }


        public Payment getByCardNumber(String cardNumber){
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Payment> query = criteriaBuilder.createQuery(Payment.class);

            Root<Payment> paymentTable = query.from(Payment.class);
            query.select(paymentTable)
                    .where(criteriaBuilder.equal(paymentTable.get("cardNumber"), cardNumber));

            return session.createQuery(query).getSingleResult();
        }

    @Override
    public void delete(Payment payment) {
        Transaction tx = session.beginTransaction();
        if(payment != null){
            session.delete(payment);
        }
        tx.commit();
    }

}
