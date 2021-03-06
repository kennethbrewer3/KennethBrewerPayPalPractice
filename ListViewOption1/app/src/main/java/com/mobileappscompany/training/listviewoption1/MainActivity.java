package com.mobileappscompany.training.listviewoption1;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;


public class MainActivity extends ActionBarActivity {
    private final String TAG = "LVO1:MainActivity";
    private ListView list;
    private ImageView headerImageView;
    private ImageButton removeButton;
    private TextView headerTextView;
    private String[] countries;
    ArrayList<String> countryArrayList;
    private Context context;
    private MyArrayAdapter myAdapter;
    private int currentPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list=(ListView)findViewById(R.id.list);
        headerImageView = (ImageView)findViewById(R.id.headerImageView);
        headerTextView=(TextView)findViewById(R.id.headerTextView);
        countries=getResources().getStringArray(R.array.countries);
        countryArrayList = new ArrayList(Arrays.asList(countries));
        currentPosition = 0;
        context=getBaseContext();


        myAdapter = new MyArrayAdapter(this,android.R.layout.simple_list_item_1,R.id.headerTextView,countryArrayList);

        Log.d(TAG,"myAdapter instantiated");

        list.setAdapter(myAdapter);
        Log.d(TAG,"myAdapter set for the listview");
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                currentPosition = position;
                String country = countryArrayList.get(position);
                int imageId = context.getResources().getIdentifier(getFlagName(country),"drawable",context.getPackageName());
                Log.d(TAG, "country: " + getFlagName(country) + " imageId: " + imageId );
                headerImageView.setImageResource(imageId);
                headerTextView.setText(country);
            }
        });

        addListenerOnRemoveButton();
    }

    public void addListenerOnRemoveButton() {

        removeButton = (ImageButton) findViewById(R.id.removeButton);

        removeButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Log.d(TAG,"currentPosition: " + currentPosition);
                String toRemove = myAdapter.getItem(currentPosition);
                Log.d(TAG,"String to remove: " + toRemove);
                myAdapter.remove(toRemove);
                myAdapter.notifyDataSetChanged();
            }

        });

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

    private String getFlagName(String country) {
        return country.replaceAll("\\s+","").toLowerCase();
    }
}
