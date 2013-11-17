package com.bookmytable;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class TableSelectionActivity extends Activity implements View.OnClickListener {
    private ImageView selected;
    ArrayList<ImageView> tables;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_selection);

        tables = new ArrayList<ImageView>();
        tables.add((ImageView) findViewById(R.id.t1));
        tables.add((ImageView) findViewById(R.id.t2));
        tables.add((ImageView) findViewById(R.id.t3));
        tables.add((ImageView) findViewById(R.id.t4));
        tables.add((ImageView) findViewById(R.id.t5));
        tables.add((ImageView) findViewById(R.id.t8));
        tables.add((ImageView) findViewById(R.id.t9));
        tables.add((ImageView) findViewById(R.id.t10));
        tables.add((ImageView) findViewById(R.id.t11));
        tables.add((ImageView) findViewById(R.id.t13));
        tables.add((ImageView) findViewById(R.id.t14));
        tables.add((ImageView) findViewById(R.id.t15));
        tables.add((ImageView) findViewById(R.id.t16));
        tables.add((ImageView) findViewById(R.id.t17));
        tables.add((ImageView) findViewById(R.id.t18));
        tables.add((ImageView) findViewById(R.id.t20));
        tables.add((ImageView) findViewById(R.id.t21));

        for (ImageView table : tables) {
            table.setOnClickListener(this);
        }

    }

    @Override
    public void onClick(View v) {
        if (v.getClass().getSimpleName().equals("ImageView")) {
            selected = (ImageView) v;
            for (ImageView table : tables) {
                table.setImageResource(getImageResourceFromTag(table.getTag()));
            }
            selected.setImageResource(getSelectedImageResourceFromTag(selected.getTag()));
        }
    }

    private int getImageResourceFromTag(Object tag) {
        if (tag.equals("2")) {
            return R.drawable.tab2;
        } else if (tag.equals("4")) {
            return R.drawable.tab4;
        } else {
            return R.drawable.tab6;
        }
    }


    private int getSelectedImageResourceFromTag(Object tag) {
        if (tag.equals("2")) {
            return R.drawable.tab2s;
        } else if (tag.equals("4")) {
            return R.drawable.tab4s;
        } else {
            return R.drawable.tab6s;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.table_selection, menu);
        return true;
    }

    public void navigateToBookingActivity(View view) {
        startActivity(new Intent(this, BookingActivity.class));
    }

    public void navigateToBookingConfirmationActivity(View view) {
        startActivity(new Intent(this, BookingConfirmationActivity.class));
    }
}
