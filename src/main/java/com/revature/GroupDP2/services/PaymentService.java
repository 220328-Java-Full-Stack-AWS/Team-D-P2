package com.revature.GroupDP2.services;

import com.revature.GroupDP2.model.Payment;
import com.revature.GroupDP2.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    PaymentRepository paymentRepo;

    public void save(Payment payment) {
        System.out.println(payment);
         paymentRepo.create(payment);

    }

    public Payment getPaymentById(Integer id) {
        return paymentRepo.getById(id).get();
    }

    public List<Payment> getAll() {
        return paymentRepo.getAll();
    }

    public void delete(Payment payment) {
        paymentRepo.delete(payment);

    }
}
