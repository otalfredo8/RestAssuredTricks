package com.app.pojos.pojoscyber;

public class User {
    private String title;
    private String first;
    private String last;

    private UserAddress userAddress;

    public User(String title, String first, String last, UserAddress userAddress){
        this.title = title;
        this.first = first;
        this.last = last;
        this.userAddress = userAddress;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public UserAddress getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(UserAddress userAddress) {
        this.userAddress = userAddress;
    }
}

