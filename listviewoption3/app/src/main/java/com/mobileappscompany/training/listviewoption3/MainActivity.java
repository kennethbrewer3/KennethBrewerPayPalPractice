package com.mobileappscompany.training.listviewoption3;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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

    float historicX = Float.NaN, historicY = Float.NaN;
    static final int DELTA = 50;
    enum Direction {LEFT, RIGHT;}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list=(ListView)findViewById(R.id.list);
        list.setLongClickable(true);
        //headerImageView = (ImageView)findViewById(R.id.headerImageView);
        headerTextView=(TextView)findViewById(R.id.headerTextView);
        countries=getResources().getStringArray(R.array.countries);
        countryArrayList = new ArrayList(Arrays.asList(countries));
        currentPosition = 0;
        context=getBaseContext();


        myAdapter = new MyArrayAdapter(this,android.R.layout.simple_list_item_1,R.id.headerTextView,countryArrayList);

        Log.d(TAG,"myAdapter instantiated");

        list.setAdapter(myAdapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                currentPosition = position;
                String country = countryArrayList.get(position);
            }
        });

        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                                           int position, long id) {
                currentPosition = position;
                String country = countryArrayList.get(position);


//                new EditDeleteDialog().show(getFragmentManager(),"");
                Log.v("long clicked","position: " + position);

                return true;
            }
        });

        SwipeDismissListViewTouchListener touchListener =
                 new SwipeDismissListViewTouchListener(list,
                         new SwipeDismissListViewTouchListener.DismissCallbacks() {
                                 public void onDismiss(ListView listView, int[] reverseSortedPositions) {
                                         for (int position : reverseSortedPositions) {
                                             myAdapter.remove(myAdapter.getItem(position));
                                             }
                                     myAdapter.notifyDataSetChanged();
                                     }
                                 public boolean canDismiss(int param) {
                                     return true;
                                 }
                             });
         list.setOnTouchListener(touchListener);
         list.setOnScrollListener(touchListener.makeScrollListener());
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
