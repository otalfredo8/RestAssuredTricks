package com.app.pojos.pojosrandomusers;

import com.google.gson.annotations.SerializedName;

public class Name {
    @SerializedName("last")
    private String last;
    @SerializedName("first")
    private String first;
    @SerializedName("title")
    private String title;

//    public Name(String last, String first, String title) {
//        this.last = last;
//        this.first = first;
//        this.title = title;
//    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString(){
        return "name:{" +
                "last='" + last + '\'' +
                ", first='" + first + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
