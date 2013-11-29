package com.bookmytable.utilities;

import com.bookmytable.entities.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * Created by Pranit on 11/17/13.
 */
public class StaticContent {

    public static HashMap<String, User> users = new HashMap<String, User>();
    public static ArrayList<String> restaurants = new ArrayList<String>();

    static {
        // users
        users.put("pranit", new User("pranit", "pranit123", "Pranit"));
        users.put("ankit", new User("ankit", "ankit123", "Ankit"));
        users.put("ishita", new User("ishita", "ishita123", "Ishita"));

        // restaurants
        restaurants.add("Jack In The Box");
        restaurants.add("Manas Indian Cuisine");
        restaurants.add("Pizzeria Mozza");
        restaurants.add("Gjelina");
        restaurants.add("Yard House");
        restaurants.add("The Counter");
        restaurants.add("Acabar");
        restaurants.add("Paiche");
        restaurants.add("La Plaza Grill");
        restaurants.add("Perche");
        restaurants.add("Katsuya");
        restaurants.add("Pasta Roma");
        restaurants.add("Bacaro LA");
        restaurants.add("Yuko Kitchen");
        restaurants.add("Providence");
        restaurants.add("Sushi Zo");
        restaurants.add("Red Medicine");
        Collections.sort(restaurants);
    }
}
