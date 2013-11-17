package com.bookmytable.services;

import com.bookmytable.entities.User;
import com.bookmytable.utilities.StaticContent;

import java.util.HashMap;

public class AuthenticationService {

    public static User login(String username, String password) {
        HashMap<String, User> users = StaticContent.users;
        if (users.containsKey(username)) {
            User user = users.get(username);
            if(user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
}
