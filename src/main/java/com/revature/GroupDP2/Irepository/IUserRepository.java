package com.revature.GroupDP2.Irepository;

import com.revature.GroupDP2.model.User;
import org.hibernate.Session;

import java.util.Optional;

public interface IUserRepository extends IGenericRepository<User>{
    Optional<User> getByUsername(String username, Session session);

}

