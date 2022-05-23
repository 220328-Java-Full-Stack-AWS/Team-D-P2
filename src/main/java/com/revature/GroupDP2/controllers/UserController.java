package com.revature.GroupDP2.controllers;

import com.revature.GroupDP2.model.User;
import com.revature.GroupDP2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping
    public User login(@RequestBody User user)throws ResponseStatusException{
            return userService.login(user);
    }
    @PostMapping
    public User register(@RequestBody User user) throws ResponseStatusException {
        return userService.register(user);
    }
    @PutMapping
    public User update(@RequestBody User user) throws ResponseStatusException {
            return userService.edit(user);

    }

    @PutMapping("/addCart")
    public void addCart(@RequestHeader("cartId") Integer cartId, @RequestHeader("userId") Integer userId){
        userService.addCart(cartId, userId);
    }

    @DeleteMapping
    public User delete(@RequestBody User user) throws ResponseStatusException{
        return userService.unregister(user);
    }

}
