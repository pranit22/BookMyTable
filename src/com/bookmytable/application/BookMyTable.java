package com.bookmytable.application;

import android.app.Application;

import com.bookmytable.entities.User;

/**
 * Created by Pranit on 11/17/13.
 */
public class BookMyTable extends Application {
    private User loggedInUser;

    public User getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(User user) {
        loggedInUser = user;
    }
}
