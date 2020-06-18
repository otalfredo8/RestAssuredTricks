package com.app.pojos.pojosrandomusers;

import com.google.gson.annotations.SerializedName;

public class Street {
    @SerializedName("name")
    private String name;
    @SerializedName("number")
    private String number;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
