package com.services.sonata.food.e.efoodfoodie.Library;


public class KeyValuePair {
    // attributes
    private String key;
    private String value;

    // constructors
    public KeyValuePair() {
        this.key = "";
        this.value = "";
    }

    public KeyValuePair(String key, String value) {
        this.key = key;
        this.value = value;
    }

    // getters
    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    // setters
    public void setKey(String key) {
        this.key = key;
    }

    public void setValue(String value) {
        this.value = value;
    }

    // methods
    @Override
    public String toString() {
        return key + "=" + value;
    }
}