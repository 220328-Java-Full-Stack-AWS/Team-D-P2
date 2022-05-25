package com.revature.GroupDP2.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Entity
@Table(name="users",schema = "groupd")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotEmpty @Size(min = 2,max = 255, message = "username should be between 2 and 255 characters")
    @Column(name="username",unique = true)
    private String username;
    @NotEmpty(message = "password can't be empty")
    @Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$", message = "password should contain at least one upper case letter," +
                                                                                        " at least one lower case letter, at least one digit, at least one special character," +
                                                                                        " and it has to be minimum 8 symbols")
    @Column(name="password")
    private String password;
    @Column
    private boolean enabled;
    @NotEmpty(message = "First name should not be empty")
    @Column(name="first_name")
    private String firstName;
    @NotEmpty(message = "Last name should not be empty")
    @Column(name="last_name")
    private String lastName;
    @NotEmpty(message = "Email should not be empty") @Email
    @Column(name="email")
    private String email;
    @Column(name="phone")
    private String phone;
    @NotEmpty(message = "Street name should not be empty")
    @Column(name="street_name")
    private String streetName;
    @NotEmpty(message = "City should not be empty")
    @Column(name="city")
    private String city;
    @NotEmpty(message = "State should not be empty")
    @Column(name="state")
    private String state;
    @NotEmpty(message = "Zip code should not be empty")
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
