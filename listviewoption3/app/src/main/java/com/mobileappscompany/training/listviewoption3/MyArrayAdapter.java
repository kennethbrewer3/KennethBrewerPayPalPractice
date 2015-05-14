package com.mobileappscompany.training.listviewoption3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Android1 on 3/4/2015.
 */
public class MyArrayAdapter extends ArrayAdapter<String> {
    private final String TAG = "LVO1:MyArrayAdapter";
    private Context context;
    ArrayList<String> countries;
    public MyArrayAdapter(Context context, int resource, int textViewResourceId, ArrayList<String> countries) {
        super(context,resource,textViewResourceId,countries);
        this.context = context;
        this.countries = countries;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
//        Log.d(TAG, "getView called (position:" + position + ")");
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.list_item,parent,false);

        //String[] items = context.getResources().getStringArray(R.array.countries);

        ImageView listIV = (ImageView)row.findViewById(R.id.listImageView);
        TextView tv1 = (TextView)row.findViewById(R.id.textView1);
        TextView tv2 = (TextView)row.findViewById(R.id.textView2);

        if(position % 2 != 0) {
            RelativeLayout.LayoutParams paramsIV1 = (RelativeLayout.LayoutParams)listIV.getLayoutParams();
            paramsIV1.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
            paramsIV1.removeRule(RelativeLayout.ALIGN_PARENT_RIGHT);
            listIV.setLayoutParams(paramsIV1);

            RelativeLayout.LayoutParams paramsTV1 = (RelativeLayout.LayoutParams)tv1.getLayoutParams();
            paramsTV1.addRule(RelativeLayout.RIGHT_OF,R.id.listImageView);
            paramsTV1.removeRule(RelativeLayout.LEFT_OF);
            tv1.setLayoutParams(paramsTV1);

            RelativeLayout.LayoutParams paramsTV2 = (RelativeLayout.LayoutParams)tv2.getLayoutParams();
            paramsTV2.addRule(RelativeLayout.RIGHT_OF,R.id.listImageView);
            paramsTV1.removeRule(RelativeLayout.LEFT_OF);
            tv2.setLayoutParams(paramsTV2);
        }
        if(position % 2 == 0) {
            RelativeLayout.LayoutParams paramsIV1 = (RelativeLayout.LayoutParams)listIV.getLayoutParams();
            paramsIV1.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
            paramsIV1.removeRule(RelativeLayout.ALIGN_PARENT_LEFT);
            listIV.setLayoutParams(paramsIV1);

            RelativeLayout.LayoutParams paramsTV1 = (RelativeLayout.LayoutParams)tv1.getLayoutParams();
            paramsTV1.addRule(RelativeLayout.LEFT_OF,R.id.listImageView);
            paramsTV1.removeRule(RelativeLayout.RIGHT_OF);
            tv1.setLayoutParams(paramsTV1);

            RelativeLayout.LayoutParams paramsTV2 = (RelativeLayout.LayoutParams)tv2.getLayoutParams();
            paramsTV2.addRule(RelativeLayout.LEFT_OF,R.id.listImageView);
            paramsTV2.removeRule(RelativeLayout.RIGHT_OF);
            tv2.setLayoutParams(paramsTV2);
        }

        String country = countries.get(position);
//        Log.d(TAG, "Country: " + getFlagName(country));

        tv1.setText(country);
        tv2.setText("something");

        int imageId = context.getResources().getIdentifier(getFlagName(country),"drawable",context.getPackageName());
        listIV.setImageResource(imageId);

        return row;
    }

    private String getFlagName(String country) {
        return country.replaceAll("\\s+","").toLowerCase();
    }
}
