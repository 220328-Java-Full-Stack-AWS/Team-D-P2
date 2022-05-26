package com.revature.GroupDP2.controllers;

import com.revature.GroupDP2.model.Payment;
import com.revature.GroupDP2.services.PaymentService;
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

    @Autowired
    public PaymentController(PaymentService paySerRepo) {

        this.paySerRepo = paySerRepo;
    }

    @GetMapping("/byUser")
    public List<Payment> getByUser(@RequestHeader("userId") Integer userId) {
        return paySerRepo.getByUser(userId);
    }


    //Add a new payment
    @PostMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Payment> addNewPayment(@Valid @RequestBody Payment payment) {
        paySerRepo.save(payment);
        return ResponseEntity.status(200).build();
    }

    //Update an existing payment
    @PutMapping ()
    @ResponseStatus(HttpStatus.OK)
    public Payment updatePayment(@Valid @RequestBody Payment payment) {
        paySerRepo.update(payment);
        return payment;
    }

    @PatchMapping
    public ResponseEntity<Payment> patch(@Valid @RequestBody Payment payment){
        paySerRepo.patch(payment);
        return ResponseEntity.status(200).build();
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


