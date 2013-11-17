package com.bookmytable;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

public class PayNowActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_now);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.pay_now, menu);
        return true;
    }

}
