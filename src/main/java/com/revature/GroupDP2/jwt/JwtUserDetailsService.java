package com.revature.GroupDP2.jwt;

import com.revature.GroupDP2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;


@Service
public class JwtUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public JwtUserDetailsService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.revature.GroupDP2.model.User user = userRepository.getByUsername(username).get();
        if (username.equals(user.getUsername())){
            return new User(user.getUsername(),user.getPassword(),new ArrayList<>());
        }
        else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}
