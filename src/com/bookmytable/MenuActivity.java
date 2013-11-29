package com.bookmytable;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bookmytable.application.BookMyTable;

public class MenuActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        TextView username = (TextView) findViewById(R.id.username);
        BookMyTable bookMyTable = (BookMyTable) getApplicationContext();
        if(bookMyTable.getLoggedInUser() == null) {
            username.setText("Welcome, Guest");
            Button button = (Button) findViewById(R.id.button2);
            ((LinearLayout)button.getParent()).removeView(button);
            button = (Button) findViewById(R.id.button3);
            ((LinearLayout)button.getParent()).removeView(button);
        }
        else {
            username.setText("Welcome, " + bookMyTable.getLoggedInUser().getName());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public void bookATable(View view) {
        startActivity(new Intent(this, BookingActivity.class));
    }

    public void exit(View view) {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    public void logout(View view) {
        ((BookMyTable) getApplicationContext()).setLoggedInUser(null);
        startActivity(new Intent(this, MainActivity.class));
    }

}
