package com.mobileappscompany.jacksonpractice;

import android.util.Log;

import com.loopj.android.http.JsonHttpResponseHandler;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Kenneth Brewer on 5/12/2015.
 */
public class JSONPlaceHolderClientUsage {
    private static final String TAG = "PlaceHolderClientUsage";

    public void getPosts() throws JSONException {
        Log.d(TAG, "About to make the request:");
        JSONPlaceHolderClient.get("/posts", null, new JsonHttpResponseHandler() {
            String posts;

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                // If the response is JSONObject instead of expected JSONArray
                try {
                    posts = response.getString("title");
                } catch (JSONException e) {
                    Log.e(TAG, "JSONException: " + e.toString());
                }

                Log.d(TAG, "Single response: " + posts);
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray responses) {
                // Pull out the first event on the public timeline
                try {
                    JSONObject firstEvent = (JSONObject) responses.get(0);
                    posts = firstEvent.getString("title");
                } catch (JSONException e) {
                    Log.e(TAG, "JSONException: " + e.toString());
                }

                Log.d(TAG, "Multiple responses: " + posts + " responseCount: " + responses.length());
            }
        });
    }
}
