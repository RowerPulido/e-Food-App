package com.services.sonata.food.e.efoodfoodie.Library;

import java.util.ArrayList;


public class KeyValuePairs extends ArrayList<KeyValuePair> {

    public boolean add(String key, String value) {
        return super.add(new KeyValuePair(key, value));
    }

    @Override
    public String toString() {
        String params = "";

        boolean first = true;
        for (int i = 0; i < size(); i++) {
            String key = get(i).getKey();
            String value = get(i).getValue();

            if (!first) {
                params += "&";
            } else {
                first = false;
            }

            params += key + "=" + value;
        }

        return params;
    }
}
