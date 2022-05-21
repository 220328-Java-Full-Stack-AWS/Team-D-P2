package com.revature.GroupDP2.controllers;

import com.revature.GroupDP2.dtos.Token;
import com.revature.GroupDP2.dtos.UserDto;
import com.revature.GroupDP2.jwt.JwtUserDetailsService;
import com.revature.GroupDP2.jwt.TokenManager;
import com.revature.GroupDP2.model.User;
import com.revature.GroupDP2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;


@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final JwtUserDetailsService jwtUserDetailsService;
    private final AuthenticationManager authenticationManager;
    private final TokenManager tokenManager;
    @Autowired
    public UserController(UserService userService, JwtUserDetailsService jwtUserDetailsService, AuthenticationManager authenticationManager, TokenManager tokenManager) {
        this.userService = userService;
        this.jwtUserDetailsService = jwtUserDetailsService;
        this.authenticationManager = authenticationManager;
        this.tokenManager = tokenManager;
    }
    @PostMapping("/login")
    public ResponseEntity<Token> login(@RequestBody UserDto userDto) throws Exception{
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userDto.getUsername(),userDto.getPassword()));
        }
        catch (DisabledException e){
            throw new Exception("User Disabled", e);
        }
        catch (BadCredentialsException e){
            throw new Exception("Invalid Credentials", e);
        }
        final UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(userDto.getUsername());
        final String token = tokenManager.generateToken(userDetails,userDto);

        return ResponseEntity.ok(new Token(token));
        //return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, responseCookie.toString()).build();

    }


    @PostMapping("/register")
    public User register(@RequestBody User user) throws Exception {
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
