package com.bookmytable;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.bookmytable.entities.User;
import com.bookmytable.services.AuthenticationService;
import com.bookmytable.application.BookMyTable;

public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText password = (EditText) findViewById(R.id.password);
        password.setTypeface(Typeface.DEFAULT);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.login, menu);
        return true;
    }

    public void login(View view) {
        String username = ((EditText) (findViewById(R.id.username))).getText().toString().toLowerCase();
        String password = ((EditText) (findViewById(R.id.password))).getText().toString();
        User user = AuthenticationService.login(username, password);
        if(user != null) {
            ((BookMyTable) getApplicationContext()).setLoggedInUser(user);
            startActivity(new Intent(this, MenuActivity.class));
        } else {
            Toast.makeText(this, "Login Failed!", Toast.LENGTH_SHORT).show();
        }
    }

    public void navigateToMainActivity(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }

}
