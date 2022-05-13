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
    @GetMapping
    public User login(@RequestBody User user)throws Exception{
            return userService.login(user).get();
    }
    @PostMapping
    public User register(@RequestBody User user) throws Exception {
            return userService.register(user).get();

    }
    @PutMapping
    public User update(@RequestBody User user) throws Exception {
            return userService.edit(user).get();

    }
}
