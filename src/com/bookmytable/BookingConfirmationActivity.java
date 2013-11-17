package com.bookmytable;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class BookingConfirmationActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_confirmation);
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
                .setMessage("Congratulations, table 2A at Yard House on Thursday, October 27, 8:00 PM has been successfully booked!")
                .setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(thisActivity, MenuActivity.class));
                    }
                })
                .show();
    }

    public void navigateToTableSelectionActivity(View view) {
        startActivity(new Intent(this, TableSelectionActivity.class));
    }

}
