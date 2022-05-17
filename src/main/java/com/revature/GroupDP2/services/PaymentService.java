package com.revature.GroupDP2.services;

import com.revature.GroupDP2.model.Payment;
import com.revature.GroupDP2.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    PaymentRepository paymentRepo;

    @Autowired
    public PaymentService(PaymentRepository paymentRepo) {
        this.paymentRepo = paymentRepo;
    }

    public void save(Payment payment) {
         paymentRepo.create(payment);

    }

    public void update(Payment payment) {
        paymentRepo.update(payment);

    }

    public Optional<Payment> getPaymentById(Integer id) {
         return Optional.ofNullable(paymentRepo.getById(id));
    }

    public Payment getPaymentByCardNumber(Payment payment){
        return paymentRepo.getPaymentByCardNumber(payment);
    }

    public List<Payment> getAll() {
        return paymentRepo.getAll();
    }

    public void delete(Payment payment) {
        paymentRepo.delete(payment);

    }


}
