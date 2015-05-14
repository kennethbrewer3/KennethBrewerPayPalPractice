package com.mobileappscompany.jacksonpractice;

import android.app.Activity;
import android.util.Log;

import com.loopj.android.http.*;

/**
 * Created by Kenneth Brewer on 5/12/2015.
 */
public class JSONPlaceHolderClient {
    private final static String TAG = "JSONPlaceHolderClient";

    private static AsyncHttpClient client = new AsyncHttpClient();

    private static final String BASE_URL = "http://jsonplaceholder.typicode.com";

    public static void get(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        Log.d(TAG, "invoking the get method");
        Log.d(TAG, "getAbsoluteUrl: " + getAbsoluteUrl(url));
        Log.d(TAG, "Client is null: " + (client == null));
        client.get(getAbsoluteUrl(url), params, responseHandler);
    }

    private static String getAbsoluteUrl(String relativeUrl) {
        return BASE_URL + relativeUrl;
    }
}
