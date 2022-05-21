package com.revature.GroupDP2.services;

import com.revature.GroupDP2.exceptions.AlredyExsistsException;
import com.revature.GroupDP2.exceptions.InvalidEmailException;
import com.revature.GroupDP2.exceptions.UnableException;
import com.revature.GroupDP2.exceptions.UnauthorizedException;
import com.revature.GroupDP2.model.User;
import com.revature.GroupDP2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Locale;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
    this.userRepository=userRepository;
    }
    /*
    1. check if username is unique
    2. check if email is valid
    3. check if there is a password
     */
    public User register(User user) throws Exception {
        if (userRepository.getByUsername(user.getUsername()).isPresent()) {
            //throw new AlredyExsistsException("username already taken!");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username already exists!");
        }//email validator. got it online
        user.setEmail(user.getEmail().toLowerCase(Locale.ROOT));
        if(!user.getEmail().matches("^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$")){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email invalid!");
            //throw new InvalidEmailException("email invalid!");
        }
        userRepository.create(user);
        return user;
    }
    public User login(User user) throws Exception{
        Optional<User> oldUser = userRepository.getByUsername(user.getUsername());
        if(oldUser.isPresent()&&user.getPassword().equals(oldUser.get().getPassword())){
            return oldUser.get();
        }
        throw new UnauthorizedException("login fail!");
    }
    /*
    1. see if exists
    2.see if password is null
    3.see if email is valid
    4. update
     */
    public User edit(User user) throws Exception {
    Optional<User> oldUser=userRepository.getById(user.getId());
    if(oldUser.isPresent()&&user.getPassword()!=null){
        user.setEmail(user.getEmail().toLowerCase(Locale.ROOT));
        if(!user.getEmail().matches("^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$")) {
            throw new InvalidEmailException("email invalid!");
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
        throw new UnableException("update fail!");
    }
    public User unregister(User user) throws Exception {
        Optional<User> oldUser =userRepository.getByUsername(user.getUsername());
        if(oldUser.isPresent()){
            userRepository.delete(oldUser.get());
            return oldUser.get();
        }
        throw new UnableException("could not delete!");
    }

    public void addCart(Integer cartId, Integer userId){
        userRepository.addCart(cartId, userId);
    }
}


