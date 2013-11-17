package com.bookmytable;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;

public class TableSelectionActivity extends Activity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_table_selection);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
	// Inflate the menu; this adds items to the action bar if it is present.
	getMenuInflater().inflate(R.menu.table_selection, menu);
	return true;
    }

    public void navigateToBookingActivity (View view)
    {
        startActivity(new Intent(this, BookingActivity.class));
    }

    public void navigateToBookingConfirmationActivity (View view)
    {
        startActivity(new Intent(this, BookingConfirmationActivity.class));
    }
}
