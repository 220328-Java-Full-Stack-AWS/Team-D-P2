package com.revature.GroupDP2.services;

import com.revature.GroupDP2.model.User;
import com.revature.GroupDP2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Locale;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final CartService cartService;
    @Autowired
    public UserService(UserRepository userRepository, CartService cartService) {
        this.userRepository=userRepository;
        this.cartService = cartService;
    }
    /*
    1. check if username is unique
    2. check if email is valid
    3. check if there is a password
     */
    public User register(User user) throws ResponseStatusException {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
        user.setPassword(encoder.encode(user.getPassword()));
        if (userRepository.getByUsername(user.getUsername()).isPresent()) {
            //throw new AlredyExsistsException("username already taken!");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username already exists!");
        }//email validator. got it online
        user.setEmail(user.getEmail().toLowerCase(Locale.ROOT));
        if(!user.getEmail().matches("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$")){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email invalid!");
            //throw new InvalidEmailException("email invalid!");
        }
        user.setCart(cartService.newCart());
        userRepository.create(user);

        return user;
    }
    public User login(User user) throws ResponseStatusException{
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
        Optional<User> oldUser = userRepository.getByUsername(user.getUsername());
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
    public User edit(User user) throws ResponseStatusException {
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
        userRepository.update(outUser);
        return outUser;
    }
        throw new ResponseStatusException(HttpStatus.FORBIDDEN,"auth failed!");
    }
    public User unregister(User user) throws ResponseStatusException {
        Optional<User> oldUser =userRepository.getByUsername(user.getUsername());
        if(oldUser.isPresent()){
            userRepository.delete(oldUser.get());
            return oldUser.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,"failed to delete!");

    }

    public User getById(Integer userId) {
        return userRepository.getById(userId).get();

    }

    public void addCart(Integer cartId, Integer userId){
        userRepository.addCart(cartId, userId);
    }
}


