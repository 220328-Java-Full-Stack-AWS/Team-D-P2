package com.revature.GroupDP2.services;

import com.revature.GroupDP2.model.Payment;
import com.revature.GroupDP2.model.User;
import com.revature.GroupDP2.repository.PaymentRepository;
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

    public void save(Payment payment) {
         paymentRepo.create(payment);

    }

    public void update(Payment payment) {
        paymentRepo.update(payment);

    }

    public void patch(Payment payment){
        paymentRepo.patch(payment);
    }

    public Optional<Payment> getPaymentById(Integer id) {
         return paymentRepo.getById(id);
    }

    public Payment getPaymentByCardNumber(Payment payment){
        return paymentRepo.getPaymentByCardNumber(payment);

    }

    public List<Payment> getByUser(Integer userId) {
        User user = userService.getById(userId);
        return paymentRepo.getByUser(user);
    }

    public List<Payment> getAll() {
        return paymentRepo.getAll();
    }

    public void delete(Payment payment) {
        paymentRepo.delete(payment);

    }


}
