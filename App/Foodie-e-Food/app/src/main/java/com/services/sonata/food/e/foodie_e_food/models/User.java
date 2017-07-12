package com.services.sonata.food.e.foodie_e_food.models;

import android.graphics.drawable.Drawable;

import com.services.sonata.food.e.foodie_e_food.Methods;

/**
 * Created by jorge on 06/07/2017.
 */

public class User {
    private String email;
    private String username;
    private String phoneNumber;
    private Drawable picture;

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Drawable getPicture() {
        return picture;
    }

    public User() {
        this.email = "";
        this.username = "";
        this.phoneNumber = "";
    }

    /**
     * Construct the object of @Class User
     *
     * @param email
     * @param username
     * @param phoneNumber
     */
    public User(String email, String username, String phoneNumber) {
        this.email = email;
        this.username = username;
        this.phoneNumber = phoneNumber;
    }

    /**
     * Construct the object of @Class User
     *
     * @param email
     * @param username
     * @param phoneNumber
     * @param picture
     */
    public User(String email, String username, String phoneNumber, Drawable picture) {
        this.email = email;
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.picture = picture;
    }

    /**
     * Construct the object of @Class User
     *
     * @param email
     * @param username
     * @param phoneNumber
     * @param urlImage
     */
    public User(String email, String username, String phoneNumber, String urlImage) {
        this.email = email;
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.picture = Methods.drawableFromURL(urlImage);
    }
}
