package com.app.pojos.pojosrandomusers;

import com.google.gson.annotations.SerializedName;

public class Info {
    @SerializedName("version")
    private String version;
    @SerializedName("page")
    private String page;
    @SerializedName("results")
    private String results;
    @SerializedName("seed")
    private String seed;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getResults() {
        return results;
    }

    public void setResults(String results) {
        this.results = results;
    }

    public String getSeed() {
        return seed;
    }

    public void setSeed(String seed) {
        this.seed = seed;
    }
}
