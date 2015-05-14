package com.mobileappscompany.jacksonpractice;

import org.json.JSONException;

/**
 * Created by Android1 on 5/12/2015.
 */
public class TestJPHCU {
    public static void main(String[] args) {
        JSONPlaceHolderClientUsage client = new JSONPlaceHolderClientUsage();

        try {
            client.getPosts();
        }catch(JSONException e) {
            System.out.println(e.toString());
        }
    }
}
