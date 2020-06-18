package com.app.pojos.pojosrandomusers;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RandomUser {

    @SerializedName("info")
    private Info info;
    @SerializedName("results")
    private List<Results> results;

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public List<Results> getResults() {
        return results;
    }

    public void setResults(List<Results> results) {
        this.results = results;
    }
}
