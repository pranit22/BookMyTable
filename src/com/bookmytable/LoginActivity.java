package com.bookmytable;

import com.bookmytable.services.AuthenticationService;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_login);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
	// Inflate the menu; this adds items to the action bar if it is present.
	getMenuInflater().inflate(R.menu.login, menu);
	return true;
    }
    
    public void login(View view)
    {
	String username= ((EditText)(findViewById(R.id.username))).getText().toString().toLowerCase();
	String password= ((EditText)(findViewById(R.id.password))).getText().toString();
	if(AuthenticationService.login(username, password))
	{
	    Toast.makeText(this, "Login Successful!", Toast.LENGTH_SHORT).show();
	}
	else
	{
	    Toast.makeText(this, "Login Failed!", Toast.LENGTH_SHORT).show();
	}
    }

}
