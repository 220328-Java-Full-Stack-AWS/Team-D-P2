package com.revature.GroupDP2.services;

import com.revature.GroupDP2.exceptions.AlredyExsistsException;
import com.revature.GroupDP2.exceptions.InvalidEmailException;
import com.revature.GroupDP2.exceptions.UnableException;
import com.revature.GroupDP2.exceptions.UnauthorizedException;
import com.revature.GroupDP2.model.User;
import com.revature.GroupDP2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        if (userRepository.getByUsername(user.getUserName()).isPresent()) {
            throw new AlredyExsistsException("username already taken!");
        }//email validator. got it online
        user.setEmail(user.getEmail().toUpperCase(Locale.ROOT));
        if(!user.getEmail().matches("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$")){
            throw new InvalidEmailException("email invalid!");
        }
        userRepository.create(user);
        return user;
    }
    public User login(User user) throws Exception{
        Optional<User> oldUser=userRepository.getByUsername(user.getUserName());
        if(oldUser.isPresent()&&oldUser.get().getPassword().equals(user.getPassword())){
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
        user.setEmail(user.getEmail().toUpperCase(Locale.ROOT));
        if(!user.getEmail().matches("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$")) {
            throw new InvalidEmailException("email invalid!");
        }
        User outUser=oldUser.get();
        outUser.setUserName(user.getUserName());
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
    public User unRegister(User user) throws Exception {
        Optional<User> oldUser =userRepository.getByUsername(user.getUserName());
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


