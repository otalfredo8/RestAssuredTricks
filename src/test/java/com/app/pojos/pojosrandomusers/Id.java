package com.app.pojos.pojosrandomusers;

import com.google.gson.annotations.SerializedName;

public class Id {
    @SerializedName("value")
    private String value;
    @SerializedName("name")
    private String name;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
