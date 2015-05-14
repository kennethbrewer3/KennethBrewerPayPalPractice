package com.mobileappscompany.training.resizingexcercise;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    private final String TAG = "MainActivity";

    EditText firstName;

    ImageButton edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstName = (EditText)findViewById(R.id.first_name_value);

        firstName.setBackgroundColor(Color.parseColor("#808080"));
        firstName.setEnabled(false);

        edit = (ImageButton)findViewById(R.id.edit);
        edit.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.edit:
                Log.i(TAG, "Edit button clicked!");
                firstName.setBackgroundColor(Color.parseColor("#FFFFFF"));
                firstName.setEnabled(true);
                break;
        }
    }
}
