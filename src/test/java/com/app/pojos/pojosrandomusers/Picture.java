package com.app.pojos.pojosrandomusers;

import com.google.gson.annotations.SerializedName;

public class Picture {
    @SerializedName("thumbnail")
    private String thumbnail;
    @SerializedName("medium")
    private String medium;
    @SerializedName("large")
    private String large;

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }
}
