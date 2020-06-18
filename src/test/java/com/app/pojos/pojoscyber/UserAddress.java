package com.app.pojos.pojoscyber;

public class UserAddress {
    private String street;
    private String city;
    private String state;
    private String zip;

    public UserAddress(String street, String city, String state, String zip) {
        this.city = city;
        this.street = street;
        this.state = state;
        this.zip = zip;
    }
}