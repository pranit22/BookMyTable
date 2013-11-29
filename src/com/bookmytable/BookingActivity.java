package com.bookmytable;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;

import com.bookmytable.application.BookMyTable;
import com.bookmytable.entities.Booking;
import com.bookmytable.entities.User;
import com.bookmytable.utilities.Conversions;
import com.bookmytable.utilities.StaticContent;

import java.util.Calendar;

public class BookingActivity extends Activity {

    Button navigateToTableSelectionActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        Spinner s = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, StaticContent.restaurants);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
        s.setAdapter(spinnerArrayAdapter);

        navigateToTableSelectionActivity = (Button)findViewById(R.id.button4);
        navigateToTableSelectionActivity.setEnabled(false);

        final EditText guests = (EditText) findViewById(R.id.guests);
        guests.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
        	if(guests.getText().length() == 0) {
        	    navigateToTableSelectionActivity.setEnabled(false);
        	}
        	else {
        	    navigateToTableSelectionActivity.setEnabled(true);
        	}
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.booking, menu);
        return true;
    }

    public void navigateToMenuActivity(View view) {
        startActivity(new Intent(this, MenuActivity.class));
    }

    public void navigateToTableSelectionActivity(View view) {
        User user = ((BookMyTable) getApplicationContext()).getLoggedInUser();
        String restaurant = ((Spinner) findViewById(R.id.spinner1)).getSelectedItem().toString();
        Calendar date = Conversions.getCalendarFromDateTimePicker(
                (DatePicker) findViewById(R.id.datePicker1),
                (TimePicker) findViewById(R.id.timePicker1));
        int guests = Integer.parseInt(((EditText)findViewById(R.id.guests)).getText().toString());

        Booking booking = new Booking();
        booking.setUser(user);
        booking.setRestaurant(restaurant);
        booking.setDate(date);
        booking.setGuests(guests);

        Intent intent = new Intent(this, TableSelectionActivity.class);
        intent.putExtra("booking", booking);
        startActivity(intent);
    }


}
