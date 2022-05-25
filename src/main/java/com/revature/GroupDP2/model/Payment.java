package com.revature.GroupDP2.model;

import org.hibernate.validator.constraints.CreditCardNumber;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "payment", schema = "groupd")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @NotEmpty @CreditCardNumber(message = "Not a valid credit card number")
    @Column(name = "card_number")
    private String cardNumber;

    @NotEmpty
    @Column(name = "expiration_date")
    private String expirationDate;

    @NotEmpty
    @Column(name = "cvv_number")
    private Integer cvvNumber;


    @ManyToOne
    private User user;

    public Payment() {
//comment
    }

    public Payment(String cardNumber , String expirationDate , Integer cvvNumber) {
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

    public Integer getCvvNumber() {

        return cvvNumber;
    }

    public void setCvvNumber(Integer cvvNumber) {

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
