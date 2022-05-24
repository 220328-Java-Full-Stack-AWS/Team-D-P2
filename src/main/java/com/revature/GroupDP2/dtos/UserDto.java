package com.revature.GroupDP2.dtos;

import java.io.Serializable;

public class UserDto implements Serializable {

    private String username;

    private String password;

    private static final long serialVersionUID = 2636936156391265891L;

    public UserDto(){

    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
