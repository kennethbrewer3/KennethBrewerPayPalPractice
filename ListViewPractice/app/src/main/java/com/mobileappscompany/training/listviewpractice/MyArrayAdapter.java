package com.mobileappscompany.training.listviewpractice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Android1 on 3/4/2015.
 */
public class MyArrayAdapter extends ArrayAdapter<String>{
    private Context context;
    public MyArrayAdapter(Context context, int resource, int textViewResourceId, String[] strings) {
        super(context,resource,textViewResourceId,strings);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.list_item,parent,false);

        String[] items = context.getResources().getStringArray(R.array.countries);

        ImageView iv1 = (ImageView)row.findViewById(R.id.imageView1);
        TextView tv1 = (TextView)row.findViewById(R.id.textView1);
        TextView tv2 = (TextView)row.findViewById(R.id.textView2);

        if(position % 2 != 0) {
            RelativeLayout.LayoutParams paramsIV1 = (RelativeLayout.LayoutParams)iv1.getLayoutParams();
            paramsIV1.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
            paramsIV1.removeRule(RelativeLayout.ALIGN_PARENT_RIGHT);
            iv1.setLayoutParams(paramsIV1);

            RelativeLayout.LayoutParams paramsTV1 = (RelativeLayout.LayoutParams)tv1.getLayoutParams();
            paramsTV1.addRule(RelativeLayout.RIGHT_OF,R.id.imageView1);
            paramsTV1.removeRule(RelativeLayout.LEFT_OF);
            tv1.setLayoutParams(paramsTV1);

            RelativeLayout.LayoutParams paramsTV2 = (RelativeLayout.LayoutParams)tv2.getLayoutParams();
            paramsTV2.addRule(RelativeLayout.RIGHT_OF,R.id.imageView1);
            paramsTV1.removeRule(RelativeLayout.LEFT_OF);
            tv2.setLayoutParams(paramsTV2);
        }
        if(position % 2 == 0) {
            RelativeLayout.LayoutParams paramsIV1 = (RelativeLayout.LayoutParams)iv1.getLayoutParams();
            paramsIV1.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
            paramsIV1.removeRule(RelativeLayout.ALIGN_PARENT_LEFT);
            iv1.setLayoutParams(paramsIV1);

            RelativeLayout.LayoutParams paramsTV1 = (RelativeLayout.LayoutParams)tv1.getLayoutParams();
            paramsTV1.addRule(RelativeLayout.LEFT_OF,R.id.imageView1);
            paramsTV1.removeRule(RelativeLayout.RIGHT_OF);
            tv1.setLayoutParams(paramsTV1);

            RelativeLayout.LayoutParams paramsTV2 = (RelativeLayout.LayoutParams)tv2.getLayoutParams();
            paramsTV2.addRule(RelativeLayout.LEFT_OF,R.id.imageView1);
            paramsTV2.removeRule(RelativeLayout.RIGHT_OF);
            tv2.setLayoutParams(paramsTV2);
        }

        String country = items[position];
        tv1.setText(country);
        tv2.setText("something");

        if(country.equals("Canada")) {
            iv1.setImageResource(R.drawable.canada);
        }
        if(country.equals("Austria")) {
            iv1.setImageResource(R.drawable.austria);
        }
        if(country.equals("England")) {
            iv1.setImageResource(R.drawable.england);
        }
        if(country.equals("Germany")) {
            iv1.setImageResource(R.drawable.germany);
        }
        if(country.equals("Mexico")) {
            iv1.setImageResource(R.drawable.mexico);
        }
        if(country.equals("Portugal")) {
            iv1.setImageResource(R.drawable.portugal);
        }
        if(country.equals("Spain")) {
            iv1.setImageResource(R.drawable.spain);
        }
        if(country.equals("United States")) {
            iv1.setImageResource(R.drawable.unitedstates);
        }
        return row;
    }
}
