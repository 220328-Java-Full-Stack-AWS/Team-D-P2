package com.revature.GroupDP2.controllers;

import com.revature.GroupDP2.model.Payment;
import com.revature.GroupDP2.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/payments")
public class PaymentController {

    final PaymentService paySerRepo;

    @Autowired
    public PaymentController(PaymentService paySerRepo) {

        this.paySerRepo = paySerRepo;
    }

    //Add a new payment
    @PostMapping()
    @ResponseStatus(HttpStatus.OK)
    public Payment addNewPayment(@RequestBody Payment payment) {
         paySerRepo.save(payment);
         return payment;
    }

    //Update an existing payment
    @PutMapping ()
    @ResponseStatus(HttpStatus.OK)
    public Payment updatePayment(@RequestBody Payment payment) {
        paySerRepo.update(payment);
        return payment;
    }

    //Delete an existing payment
    @DeleteMapping ()
    public Payment deletePayment(@RequestBody Payment payment) {
        Payment out = paySerRepo.getPaymentById(payment.getId()).get();
        paySerRepo.delete(out);
        return out;
    }

    //Get all payments
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Payment> paymentList() {
        return  paySerRepo.getAll();

    }

}


