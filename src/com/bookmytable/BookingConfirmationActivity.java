package com.bookmytable;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import com.bookmytable.entities.Booking;
import com.bookmytable.utilities.Conversions;

public class BookingConfirmationActivity extends Activity {
    
    Booking booking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_confirmation);
        
        booking = (Booking) getIntent().getSerializableExtra("booking");
        ((TextView)findViewById(R.id.table)).setText("Table " + booking.getTable());
        ((TextView)findViewById(R.id.restaurant)).setText(booking.getRestaurant());
        ((TextView)findViewById(R.id.guestCount)).setText("Table for " + booking.getGuests());
        ((TextView)findViewById(R.id.datetime)).setText(Conversions.printDateTime(booking.getDate()));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.booking_confirmation, menu);
        return true;
    }

    public void confirmBooking(View view) {
        
        final Activity thisActivity = this;
        new AlertDialog.Builder(this)
                .setTitle("Booking Successful!")
                .setMessage("Congratulations," +
                		" table "+ booking.getTable() +
                		" for "+ booking.getGuests() +
                		" at "+ booking.getRestaurant() +
                		" on "+ Conversions.printDateTime(booking.getDate()) +
                		" has been successfully booked!")
                .setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(thisActivity, MenuActivity.class));
                    }
                })
                .show();
    }

    public void navigateToTableSelectionActivity(View view) {
	Intent intent = new Intent(this, TableSelectionActivity.class);
	intent.putExtra("booking", booking);
        startActivity(intent);
    }

}
