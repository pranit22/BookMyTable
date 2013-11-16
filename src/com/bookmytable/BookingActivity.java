package com.bookmytable;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;

public class BookingActivity extends Activity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_booking);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
	// Inflate the menu; this adds items to the action bar if it is present.
	getMenuInflater().inflate(R.menu.booking, menu);
	return true;
    }

    public void navigateToMenuActivity (View view)
    {
        startActivity(new Intent(this, MenuActivity.class));
    }

    public void navigateToTableSelectionActivity (View view)
    {
        startActivity(new Intent(this, TableSelectionActivity.class));
    }

}
