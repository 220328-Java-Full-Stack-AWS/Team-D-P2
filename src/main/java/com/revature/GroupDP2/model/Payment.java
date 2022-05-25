package com.revature.GroupDP2.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.validator.constraints.CreditCardNumber;


import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "payment", schema = "groupd")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @NotEmpty
    @Pattern(regexp = "^[0-9]{15,16}$", message = "credit card number should be 15 or 16 digits")
    @Column(name = "card_number")
    private String cardNumber;

    @NotEmpty(message = "expiration date is empty")
    @Column(name = "expiration_date")
    private String expirationDate;

    @NotEmpty(message = "cvv number is empty")
    @Pattern(regexp = "^[0-9]{3,3}$", message = "cvv should be 3 digits")
    @Column(name = "cvv_number")
    private String cvvNumber;


    @ManyToOne
    @JsonBackReference
    private User user;

    public Payment() {
//comment
    }

    public Payment(String cardNumber , String expirationDate , String cvvNumber) {
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.cvvNumber = cvvNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {

        this.expirationDate = expirationDate;
    }

    public String getCvvNumber() {

        return cvvNumber;
    }

    public void setCvvNumber(String cvvNumber) {

        this.cvvNumber = cvvNumber;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", cardNumber='" + cardNumber + '\'' +
                ", expirationDate='" + expirationDate + '\'' +
                ", cvvNumber=" + cvvNumber +
                '}';
    }
}
