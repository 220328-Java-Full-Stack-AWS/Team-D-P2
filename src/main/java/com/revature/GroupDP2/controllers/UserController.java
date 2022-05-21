package com.revature.GroupDP2.controllers;

import com.revature.GroupDP2.model.User;
import com.revature.GroupDP2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/login")
    public User login(@RequestBody User user)throws Exception{
            return userService.login(user);
    }
    @PostMapping("/register")
    public User register(@RequestBody User user) throws Exception {
        System.out.println("we are here and we are not happy");
        System.out.println(user);
        return userService.register(user);

    }
    @PutMapping
    public User update(@RequestBody User user) throws Exception {
            return userService.edit(user);

    }

    @PutMapping("/addCart")
    public void addCart(@RequestHeader("cartId") Integer cartId, @RequestHeader("userId") Integer userId){
        userService.addCart(cartId, userId);
    }

    @DeleteMapping
    public User delete(@RequestBody User user) throws Exception{
        return userService.unregister(user);
    }

}
