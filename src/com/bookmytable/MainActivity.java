package com.bookmytable;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import com.bookmytable.application.BookMyTable;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BookMyTable bookMyTable = (BookMyTable) getApplicationContext();
        if(bookMyTable.getLoggedInUser() != null) {
            startActivity(new Intent(this, MenuActivity.class));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void navigateToLoginActivity(View view) {
        startActivity(new Intent(this, LoginActivity.class));
    }

    public void loginAsGuestUser(View view) {
        startActivity(new Intent(this, MenuActivity.class));
    }

}
