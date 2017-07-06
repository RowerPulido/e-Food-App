package com.services.sonata.food.e.foodie_e_food.models;

/**
 * Created by jorge on 06/07/2017.
 */

public class User {
    private String email;
    private String username;
    private String phoneNumber;

    public User() {
        this.email = "";
        this.username = "";
        this.phoneNumber = "";
    }

    public User(String email, String username, String phoneNumber) {
        this.email = email;
        this.username = username;
        this.phoneNumber = phoneNumber;
    }
}
