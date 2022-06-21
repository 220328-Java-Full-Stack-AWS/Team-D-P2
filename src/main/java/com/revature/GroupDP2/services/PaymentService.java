package com.revature.GroupDP2.services;

import com.revature.GroupDP2.model.Payment;
import com.revature.GroupDP2.model.User;
import com.revature.GroupDP2.repository.PaymentRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    PaymentRepository paymentRepo;
    UserService userService;

    @Autowired
    public PaymentService(PaymentRepository paymentRepo, UserService userService) {
        this.paymentRepo = paymentRepo;
        this.userService = userService;
    }

    public void save(Payment payment, Session session) {
         paymentRepo.create(payment,session);

    }

    public void update(Payment payment,Session session) {
        paymentRepo.update(payment,session);

    }

    public void patch(Payment payment,Session session){
        paymentRepo.patch(payment,session);
    }

    public Optional<Payment> getPaymentById(Integer id,Session session) {
         return paymentRepo.getById(id,session);
    }

    public Payment getPaymentByCardNumber(Payment payment,Session session){
        return paymentRepo.getPaymentByCardNumber(payment,session);

    }

    public List<Payment> getByUser(Integer userId,Session session) {
        User user = userService.getById(userId,session);
        return paymentRepo.getByUser(user,session);
    }

    public List<Payment> getAll(Session session) {
        return paymentRepo.getAll(session);
    }

    public void delete(Payment payment,Session session) {
        paymentRepo.delete(payment,session);

    }


}
