package com.mobileappscompany.training.personapp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.Toast;

import com.mobileappscompany.training.personapp.com.mobileappscompany.training.personapp.domain.Gender;
import com.mobileappscompany.training.personapp.com.mobileappscompany.training.personapp.domain.Person;

import java.util.ArrayList;
import java.util.List;


public class MainActivity  extends ActionBarActivity implements View.OnClickListener  {
    List<Person> people;

    private Button submitButton;
    private Button cancelButton;

    private EditText firstNameValue;
    private EditText lastNameValue;
    private Spinner  genderValue;
    private EditText ageValue;
    private EditText heightValue;
    private EditText weightValue;
    private EditText countryValue;
    private EditText stateValue;
    private EditText streetValue;
    private EditText streetNumberValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        people = new ArrayList();

        submitButton = (Button)findViewById(R.id.submit_button);
        cancelButton = (Button)findViewById(R.id.clear_button);

        submitButton.setOnClickListener(this);
        cancelButton.setOnClickListener(this);

        firstNameValue    = (EditText)findViewById(R.id.first_name_value);
        lastNameValue     = (EditText)findViewById(R.id.last_name_value);
        genderValue       = (Spinner) findViewById(R.id.gender_value);
        ageValue          = (EditText)findViewById(R.id.age_value);
        heightValue       = (EditText)findViewById(R.id.height_value);
        weightValue       = (EditText)findViewById(R.id.weight_value);
        countryValue      = (EditText)findViewById(R.id.country_value);
        stateValue        = (EditText)findViewById(R.id.state_value);
        streetValue       = (EditText)findViewById(R.id.street_value);
        streetNumberValue = (EditText)findViewById(R.id.street_number_value);
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
            case R.id.submit_button:
                if(validateForm()) {
                    people.add(buildPersonFromForm());

                    if(people.size() == 1) {
                        Toast.makeText(getApplicationContext(),
                                getString(R.string.people_prefix_single) +
                                        " " + people.size() + " " +
                                        getString(R.string.people_suffix_single),
                                Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(),
                                getString(R.string.people_prefix_multi) +
                                        " " + people.size() + " " +
                                        getString(R.string.people_suffix_multi),
                                Toast.LENGTH_LONG).show();
                    }
                }
                break;
            case R.id.clear_button:
                clearForm();
                break;
            default:
                break;
        }
    }

    private boolean validateForm() {
        boolean returnValue = true;
        if(firstNameValue.getText().length() == 0) {
            returnValue = false;
            Toast.makeText(getApplicationContext(), getString(R.string.no_first_name_toast),
                    Toast.LENGTH_LONG).show();
        }
        if(lastNameValue.getText().length() == 0) {
            returnValue = false;
            Toast.makeText(getApplicationContext(), getString(R.string.no_last_name_toast),
                    Toast.LENGTH_LONG).show();
        }
        if(ageValue.getText().length() == 0) {
            returnValue = false;
            Toast.makeText(getApplicationContext(),  getString(R.string.no_age_toast),
                    Toast.LENGTH_LONG).show();
        }
        if(heightValue.getText().length() == 0) {
            returnValue = false;
            Toast.makeText(getApplicationContext(), getString(R.string.no_height_toast),
                    Toast.LENGTH_LONG).show();
        }
        if(weightValue.getText().length() == 0) {
            returnValue = false;
            Toast.makeText(getApplicationContext(), getString(R.string.no_weight_toast),
                    Toast.LENGTH_LONG).show();
        }
        if(countryValue.getText().length() == 0) {
            returnValue = false;
            Toast.makeText(getApplicationContext(), getString(R.string.no_country_toast),
                    Toast.LENGTH_LONG).show();
        }
        if(stateValue.getText().length() == 0) {
            returnValue = false;
            Toast.makeText(getApplicationContext(), getString(R.string.no_state_toast),
                    Toast.LENGTH_LONG).show();
        }
        if(streetValue.getText().length() == 0) {
            returnValue = false;
            Toast.makeText(getApplicationContext(), getString(R.string.no_street_toast),
                    Toast.LENGTH_LONG).show();
        }
        if(streetNumberValue.getText().length() == 0) {
            returnValue = false;
            Toast.makeText(getApplicationContext(), getString(R.string.no_street_number_toast),
                    Toast.LENGTH_LONG).show();
        }
        return returnValue;
    }

    private Person buildPersonFromForm() {
        Person returnValue;

        returnValue = new Person(
                firstNameValue.getText().toString(),
                lastNameValue.getText().toString(),
                Gender.valueOf(genderValue.getSelectedItem().toString()),
                Integer.valueOf(ageValue.getText().toString()),
                Double.valueOf(heightValue.getText().toString()),
                Double.valueOf(weightValue.getText().toString()),
                countryValue.getText().toString(),
                stateValue.getText().toString(),
                streetValue.getText().toString(),
                streetNumberValue.getText().toString()
        );

        return returnValue;
    }

    private void clearForm() {
        firstNameValue.setText("");
        lastNameValue.setText("");
        genderValue.setSelection(0);
        ageValue.setText("1");
        heightValue.setText("50.0");
        weightValue.setText("50.0");
        countryValue.setText("");
        stateValue.setText("");
        streetValue.setText("");
        streetNumberValue.setText("");
    }
}
