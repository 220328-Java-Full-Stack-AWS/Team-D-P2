package com.revature.GroupDP2.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="users",schema = "groupd")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name="username",unique = true)
    private String username;
    @Column(name="password")
    private String password;
    @Column
    private boolean enabled;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="email")
    private String email;
    @Column(name="phone")
    private String phone;
    @Column(name="street_name")
    private String streetName;
    @Column(name="city")
    private String city;
    @Column(name="state")
    private String state;
    @Column(name="zip_code")
    private String zipCode;

    @OneToOne
    @JoinColumn(name = "cart_id")
    @JsonManagedReference
    private Cart cart;
    @Column(name="payment_methods")
    @OneToMany(mappedBy = "user", cascade = {CascadeType.DETACH, CascadeType.MERGE,CascadeType.REFRESH, CascadeType.PERSIST}, fetch=FetchType.LAZY)
    private List<Payment> paymentMethods;
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public User(String username, String password, boolean enabled, String firstName, String lastName, String email, String phone, String streetName, String city, String state, String zipCode) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.streetName = streetName;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }
    public User(){

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
    public List<Payment> getPaymentMethods() {
        return paymentMethods;
    }

    public void setPaymentMethods(List<Payment> paymentMethods) {
        this.paymentMethods = paymentMethods;
    }

    public void addPaymentMethod(Payment payment){
        paymentMethods.add(payment);
    }

    public void deletePaymentMethod(Payment payment){
        paymentMethods.remove(payment);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", streetName='" + streetName + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}
