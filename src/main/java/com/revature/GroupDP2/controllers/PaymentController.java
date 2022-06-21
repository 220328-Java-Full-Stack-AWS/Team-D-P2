package com.revature.GroupDP2.controllers;

import com.revature.GroupDP2.model.Payment;
import com.revature.GroupDP2.services.PaymentService;
import com.revature.GroupDP2.util.StorageManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/payments")
public class PaymentController {

    final PaymentService paySerRepo;
    final StorageManager storageManager;
    @Autowired
    public PaymentController(PaymentService paySerRepo, StorageManager storageManager) {

        this.paySerRepo = paySerRepo;
        this.storageManager = storageManager;
    }

    @GetMapping("/byUser")
    public List<Payment> getByUser(@RequestHeader("userId") Integer userId) {
        Session session = this.storageManager.getSessionFactory().openSession();
        List<Payment> out= paySerRepo.getByUser(userId,session);
        //session.close();
        return out;
    }


    //Add a new payment
    @PostMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Payment> addNewPayment(@Valid @RequestBody Payment payment) {
        Session session = this.storageManager.getSessionFactory().openSession();
        paySerRepo.save(payment,session);
        //session.close();
        return ResponseEntity.status(200).build();
    }

    //Update an existing payment
    @PutMapping ()
    @ResponseStatus(HttpStatus.OK)
    public Payment updatePayment(@Valid @RequestBody Payment payment) {
        Session session = this.storageManager.getSessionFactory().openSession();
        paySerRepo.update(payment,session);
        //session.close();
        return payment;
    }

    @PatchMapping
    public ResponseEntity<Payment> patch(@Valid @RequestBody Payment payment){
        Session session = this.storageManager.getSessionFactory().openSession();
        paySerRepo.patch(payment,session);
        //session.close();
        return ResponseEntity.status(200).build();
    }

    //Delete an existing payment
    @DeleteMapping ()
    public Payment deletePayment(@RequestBody Payment payment) {
        Session session = this.storageManager.getSessionFactory().openSession();
        Payment out = paySerRepo.getPaymentById(payment.getId(),session).get();
        paySerRepo.delete(out,session);
        //session.close();
        return out;
    }

    //Get all payments
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Payment> paymentList() {
        Session session = this.storageManager.getSessionFactory().openSession();
        List<Payment> out = paySerRepo.getAll(session);
        //session.close();
        return out;

    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

}


