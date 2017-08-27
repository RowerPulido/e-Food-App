package com.services.sonata.food.e.efoodfoodie;

import com.services.sonata.food.e.efoodfoodie.Models.Order;
import com.services.sonata.food.e.efoodfoodie.Models.User;

import java.util.ArrayList;

/**
 * Created by jorge on 15/08/2017.
 * <p>
 * Class to Variables Statics or Objects, also has ROUTES for Apis
 */

public class V {
    /**
     * ROUTES OF APIS
     */
    public static class URL {
        private static String APIS_URL = "";
        public static String GET_DISH = APIS_URL + "";
    }

    /**
     * Actual User
     */
    User aUser = new User();

    /**
     * Shopping Cart
     */
    ArrayList<Order> aShoppingCart = new ArrayList<>();


}
