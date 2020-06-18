package com.app.pojos.pojosrandomusers;

import com.google.gson.annotations.SerializedName;

public class Timezone {
    @SerializedName("description")
    private String description;
    @SerializedName("offset")
    private String offset;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }
}
