package com.bookmytable;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public class PaymentDetailsActivity extends Activity
{

    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_payment_details);
	
	final EditText editText1 = (EditText) findViewById(R.id.ccnum1);
    final EditText editText2 = (EditText) findViewById(R.id.ccnum2);
    final EditText editText3 = (EditText) findViewById(R.id.ccnum3);
    final EditText editText4 = (EditText) findViewById(R.id.ccnum4);
    final EditText editText5 = (EditText) findViewById(R.id.cvv);
	
	editText1.setOnKeyListener(new View.OnKeyListener() {
        @Override
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (keyEvent.getAction() == KeyEvent.ACTION_UP) {
                if (editText1.getText().length() == 4) {
                    editText2.requestFocus();
                }
            }
            return false;
        }
    });
	
	editText2.setOnKeyListener(new View.OnKeyListener() {
        @Override
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (keyEvent.getAction() == KeyEvent.ACTION_UP) {
                if (editText2.getText().length() == 4) {
                    editText3.requestFocus();
                }
            }
            return false;
        }
    });
	
	editText3.setOnKeyListener(new View.OnKeyListener() {
        @Override
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (keyEvent.getAction() == KeyEvent.ACTION_UP) {
                if (editText3.getText().length() == 4) {
                    editText4.requestFocus();
                }
            }
            return false;
        }
    });
	
	editText4.setOnKeyListener(new View.OnKeyListener() {
        @Override
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (keyEvent.getAction() == KeyEvent.ACTION_UP) {
                if (editText4.getText().length() == 4) {
                    editText4.clearFocus();
                    InputMethodManager imm = (InputMethodManager)getSystemService(
                    	      Context.INPUT_METHOD_SERVICE);
                    	imm.hideSoftInputFromWindow(editText4.getWindowToken(), 0);
                }
            }
            return false;
        }
    });

   editText5.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == KeyEvent.ACTION_UP) {
                    if (editText5.getText().length() == 3) {
                        editText5.clearFocus();
                        InputMethodManager imm = (InputMethodManager)getSystemService(
                                Context.INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(editText4.getWindowToken(), 0);
                    }
                }
                return false;
   }
        });

	}

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
	// Inflate the menu; this adds items to the action bar if it is present.
	getMenuInflater().inflate(R.menu.payment_details, menu);
	return true;
    }
    
}
