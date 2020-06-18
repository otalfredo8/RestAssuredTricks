package com.app.pojos.pojosrandomusers;

import com.google.gson.annotations.SerializedName;

public class Registered {
    @SerializedName("age")
    private String age;
    @SerializedName("date")
    private String date;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
