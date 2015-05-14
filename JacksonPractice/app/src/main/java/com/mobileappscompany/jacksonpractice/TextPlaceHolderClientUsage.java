package com.mobileappscompany.jacksonpractice;

import android.util.Log;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.loopj.android.http.TextHttpResponseHandler;

import org.apache.http.Header;

/**
 * Created by Kenneth Brewer on 5/12/2015.
 */
public class TextPlaceHolderClientUsage {
    private static final String TAG = "TextPlaceHolderClient";


    public void getPosts(final ObjectMapper mapper) {
        Log.d(TAG, "About to make the request:");
        JSONPlaceHolderClient.get("/posts", null, new TextHttpResponseHandler() {
            @Override
            public void onStart() {
                // Initiated the request
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                Log.d(TAG, "Failure status code: " + statusCode);
            }

            @Override
            public void onFinish() {
                Log.d(TAG, "Request finished.");
            }
        });
    }
}
