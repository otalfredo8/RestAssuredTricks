package com.app.pojos.pojosrandomusers;

import com.google.gson.annotations.SerializedName;

public class Location {
    @SerializedName("timezone")
    private Timezone timezone;
    @SerializedName("coordinates")
    private Coordinates coordinates;
    @SerializedName("postcode")
    private String postcode;
    @SerializedName("country")
    private String country;
    @SerializedName("state")
    private String state;
    @SerializedName("city")
    private String city;
    @SerializedName("street")
    private Street street;

    public Timezone getTimezone() {
        return timezone;
    }

    public void setTimezone(Timezone timezone) {
        this.timezone = timezone;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Street getStreet() {
        return street;
    }

    public void setStreet(Street street) {
        this.street = street;
    }
}
