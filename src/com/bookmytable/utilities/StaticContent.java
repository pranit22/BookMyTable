package com.bookmytable.utilities;

import com.bookmytable.entities.User;

import java.util.HashMap;

/**
 * Created by Pranit on 11/17/13.
 */
public class StaticContent {

    public static HashMap<String, User> users = new HashMap<String, User>();

    static {
        users.put("pranit", new User("pranit", "pranit123", "Pranit"));
        users.put("ankit", new User("ankit", "ankit123", "Ankit"));
        users.put("ishita", new User("ishita", "ishita123", "Ishita"));
    }
}
