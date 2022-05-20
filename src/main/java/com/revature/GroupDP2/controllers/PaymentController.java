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
    public void addNewPayment(@RequestBody Payment Payment) {
         paySerRepo.save(Payment);
    }

    //Update an existing payment
    @PutMapping ()
    @ResponseStatus(HttpStatus.OK)
    public void updatePayment(@RequestBody Payment payment) {
        paySerRepo.update(payment);

    }

    //Delete an existing payment
    @DeleteMapping ("/{id}")
    public void deletePayment(@PathVariable("id") Integer paymentId) {
        Payment payment = paySerRepo.getPaymentById(paymentId).get();
         paySerRepo.delete(payment);

    }

    //Get all payments
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Payment> paymentList() {
        return  paySerRepo.getAll();

    }

}


