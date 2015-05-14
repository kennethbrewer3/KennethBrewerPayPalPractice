package com.mobileappscompany.training.dynamiclycreatedcontrols;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {
    int children = -1;
    LinearLayout linearLayoutDynamic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonAdd = (Button)findViewById(R.id.add);
        Button buttonRemove = (Button)findViewById(R.id.remove);

        buttonAdd.setOnClickListener(this);
        buttonRemove.setOnClickListener(this);

        linearLayoutDynamic = (LinearLayout)findViewById(R.id.linearLayoutDynamic);
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
            case R.id.add:
                TextView myTextView = (TextView)new TextView(this);
                linearLayoutDynamic.addView(myTextView);
                children = children+1;
                myTextView.setText("View + " + children);
                break;
            case R.id.remove:
                if(children > -1) {
                    linearLayoutDynamic.removeView(linearLayoutDynamic.getChildAt(children));
                    children = children - 1;
                }
                break;
        }
    }
}
