package com.app.tests;

import com.app.pojos.pojoscyber.User;
import com.app.pojos.pojoscyber.UserAddress;
import com.google.gson.Gson;
import org.junit.Test;

public class Ext01_Gson_NestedObjects {


    @Test
    public void nestedObjects_Test() {


        UserAddress userAddress = new UserAddress("300 K SW", "Washington", "DC", "2003");
        User user = new User("Sr", "Karl", "Smith", userAddress);

        //TODO serialize
//        Gson gson = new Gson();
        String jsonStr = new Gson().toJson(user); //new Gson() shortcut
        System.out.println(jsonStr);

        //TODO deserialize
        User user2 = new Gson().fromJson(jsonStr, User.class); //The class that has nested objects
//        System.out.println(user2); //@Override toString()
    }
}