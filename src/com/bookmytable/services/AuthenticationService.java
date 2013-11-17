package com.bookmytable.services;

import java.util.HashMap;

public class AuthenticationService {
    private static HashMap<String, String> users = new HashMap<String, String>();

    static {
        users.put("pranit", "pranit123");
        users.put("ankit", "ankit123");
        users.put("ishita", "ishita123");
    }

    public static boolean login(String username, String password) {
        if (users.containsKey(username)) {
            if (users.get(username).equals(password)) {
                return true;
            }
        }
        return false;
    }
}
