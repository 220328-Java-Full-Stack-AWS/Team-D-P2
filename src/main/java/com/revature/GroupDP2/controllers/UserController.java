package com.revature.GroupDP2.controllers;

import com.revature.GroupDP2.model.User;
import com.revature.GroupDP2.services.UserService;
import com.revature.GroupDP2.util.StorageManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    private final StorageManager storagemanager;
    private final UserService userService;
    @Autowired
    public UserController(StorageManager storagemanager, UserService userService) {
        this.storagemanager = storagemanager;
        this.userService = userService;
    }
    //finish validation of login
    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user) throws Exception {
        Session session = this.storagemanager.getSessionFactory().openSession();
        ResponseEntity<User> out = ResponseEntity.ok(userService.login(user,session));
        //session.close();
        return out;
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@Valid @RequestBody User user) throws Exception {
        Session session = this.storagemanager.getSessionFactory().openSession();
        ResponseEntity<User> out = ResponseEntity.ok(userService.register(user,session));
        //session.close();
        return out;
    }
    @PutMapping
    public User update(@Valid @RequestBody User user) throws ResponseStatusException {
        Session session = this.storagemanager.getSessionFactory().openSession();
        User out = userService.edit(user,session);
        //session.close();
        return out;
    }

    @PutMapping("/addCart")
    public void addCart(@RequestHeader("cartId") Integer cartId, @RequestHeader("userId") Integer userId){
        Session session = this.storagemanager.getSessionFactory().openSession();
        userService.addCart(cartId, userId,session);
        //session.close();
    }

    @DeleteMapping
    public User delete(@RequestBody User user) throws ResponseStatusException{
        Session session = this.storagemanager.getSessionFactory().openSession();
        User out = userService.unregister(user,session);
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
