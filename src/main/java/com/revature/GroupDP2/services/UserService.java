package com.revature.GroupDP2.services;

import com.revature.GroupDP2.Irepository.IPaymentRepository;
import com.revature.GroupDP2.model.Cart;
import com.revature.GroupDP2.model.Payment;
import com.revature.GroupDP2.model.User;
import com.revature.GroupDP2.repository.PaymentRepository;
import com.revature.GroupDP2.repository.UserRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final CartService cartService;
    private final PaymentRepository paymentRepository;
    @Autowired
    public UserService(UserRepository userRepository, CartService cartService,PaymentRepository paymentRepository) {
        this.userRepository=userRepository;
        this.cartService = cartService;
        this.paymentRepository=paymentRepository;
    }
    /*
    1. check if username is unique
    2. check if email is valid
    3. check if there is a password
     */
    public User register(User user, Session session) throws ResponseStatusException {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
        user.setPassword(encoder.encode(user.getPassword()));
        if (userRepository.getByUsername(user.getUsername(),session).isPresent()) {
            //throw new AlredyExsistsException("username already taken!");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username already exists!");
        }//email validator. got it online
        user.setEmail(user.getEmail().toLowerCase(Locale.ROOT));
        if(!(user.getEmail().matches("^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$"))){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email invalid!");
            //throw new InvalidEmailException("email invalid!");
        }
        Cart cart=new Cart();
        user.setCart(cart);
        userRepository.create(user,session);
        //user.setCart(cartService.newCart());
        return user;
    }
    public User login(User user,Session session) throws ResponseStatusException{
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
        Optional<User> oldUser = userRepository.getByUsername(user.getUsername(),session);
        if(oldUser.isPresent()&&encoder.matches(user.getPassword(),oldUser.get().getPassword())){
            return oldUser.get();
        }
        throw new ResponseStatusException(HttpStatus.FORBIDDEN,"login fail!");
    }
    /*
    1. see if exists
    2.see if password is null
    3.see if email is valid
    4. update
     */
    public User edit(User user,Session session) throws ResponseStatusException {
    return userRepository.merge(user,session);
    }
        /*
        Optional<User> oldUser=userRepository.getById(user.getId());
        if(oldUser.isPresent()&&user.getPassword()!=null){
            user.setEmail(user.getEmail().toLowerCase(Locale.ROOT));
            if(!user.getEmail().matches("^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$")) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email invalid!");
            }
            User outUser=oldUser.get();
            outUser.setUsername(user.getUsername());
            outUser.setPassword(user.getPassword());
            outUser.setEnabled(user.isEnabled());
            outUser.setFirstName(user.getFirstName());
            outUser.setLastName(user.getLastName());
            outUser.setEmail(user.getEmail());
            outUser.setPhone(user.getPhone());
            outUser.setStreetName(user.getStreetName());
            outUser.setCity(user.getCity());
            outUser.setState(user.getState());
            outUser.setZipCode(user.getZipCode());
            outUser.setPaymentMethods(user.getPaymentMethods());
            for(Payment p: user.getPaymentMethods()){
                paymentRepository.patch(p);
                */

            /*
            Payment p2;
            if(p.getId()==0){
                p2= new Payment();
            }else {
                p2 = (Payment)paymentRepository.getById(p.getId()).get();
            }
            p2.setCardNumber(p.getCardNumber());
            p2.setCvvNumber(p.getCvvNumber());
            p2.setExpirationDate(p.getExpirationDate());
            p2List.add(p2);
            if(p.getId()==0){
                paymentRepository.create(p2);
            }

            }
            userRepository.update(outUser);
            return outUser;


        }
        throw new ResponseStatusException(HttpStatus.FORBIDDEN,"auth failed!");
    }
    */

    public User unregister(User user,Session session) throws ResponseStatusException {
        Optional<User> oldUser =userRepository.getByUsername(user.getUsername(),session);
        if(oldUser.isPresent()){
            userRepository.delete(oldUser.get(),session);
            return oldUser.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,"failed to delete!");

    }

    public User getById(Integer userId,Session session) {
        System.out.println("made it here");
        return userRepository.getById(userId,session).get();

    }

    public void addCart(Integer cartId, Integer userId,Session session){
        userRepository.addCart(cartId, userId,session);
    }
}


