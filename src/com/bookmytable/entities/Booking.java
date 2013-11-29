package com.bookmytable.entities;

import java.io.Serializable;
import java.util.Calendar;

/**
 * Created by Pranit on 11/17/13.
 */
public class Booking implements Serializable {
    User user;
    String restaurant;
    Calendar date;
    int guests;
    String table;

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(String restaurant) {
        this.restaurant = restaurant;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public int getGuests() {
        return guests;
    }

    public void setGuests(int guests) {
        this.guests = guests;
    }
}
