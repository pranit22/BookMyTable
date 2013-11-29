package com.bookmytable;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bookmytable.entities.Booking;

public class TableSelectionActivity extends Activity implements View.OnClickListener {
    private ImageView selected;
    ArrayList<ImageView> tables;
    Button navigateToConfirmationButton;
    Booking booking;

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

        navigateToConfirmationButton = (Button)findViewById(R.id.button4);
        navigateToConfirmationButton.setEnabled(false);
        
        booking = (Booking) getIntent().getSerializableExtra("booking");
    }

    @Override
    public void onClick(View v) {
        if (v.getClass().getSimpleName().equals("ImageView")) {
            selected = (ImageView) v;
            navigateToConfirmationButton.setEnabled(true);
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
        Intent intent = new Intent(this, BookingConfirmationActivity.class);
        booking.setTable(getTagIdFromActualId(selected));
        intent.putExtra("booking", booking);
        startActivity(intent);
    }
    
    private String getTagIdFromActualId(View v) {
	if(v.equals(findViewById(R.id.t1))) {
	    return "t1";
	}
	else if(v.equals(findViewById(R.id.t2))) {
	    return "t2";
	}
	else if(v.equals(findViewById(R.id.t3))) {
	    return "t3";
	}
	else if(v.equals(findViewById(R.id.t4))) {
	    return "t4";
	}
	else if(v.equals(findViewById(R.id.t5))) {
	    return "t5";
	}
	else if(v.equals(findViewById(R.id.t6))) {
	    return "t6";
	}
	else if(v.equals(findViewById(R.id.t7))) {
	    return "t7";
	}
	else if(v.equals(findViewById(R.id.t8))) {
	    return "t8";
	}
	else if(v.equals(findViewById(R.id.t9))) {
	    return "t9";
	}
	else if(v.equals(findViewById(R.id.t10))) {
	    return "t10";
	}
	else if(v.equals(findViewById(R.id.t11))) {
	    return "t11";
	}
	else if(v.equals(findViewById(R.id.t12))) {
	    return "t12";
	}
	else if(v.equals(findViewById(R.id.t13))) {
	    return "t13";
	}
	else if(v.equals(findViewById(R.id.t14))) {
	    return "t14";
	}
	else if(v.equals(findViewById(R.id.t15))) {
	    return "t15";
	}
	else if(v.equals(findViewById(R.id.t16))) {
	    return "t16";
	}
	else if(v.equals(findViewById(R.id.t17))) {
	    return "t17";
	}
	else if(v.equals(findViewById(R.id.t18))) {
	    return "t18";
	}
	else if(v.equals(findViewById(R.id.t19))) {
	    return "t19";
	}
	else if(v.equals(findViewById(R.id.t20))) {
	    return "t20";
	}
	else if(v.equals(findViewById(R.id.t21))) {
	    return "t21";
	}
	else if(v.equals(findViewById(R.id.t22))) {
	    return "t22";
	}
	
	return null;
	
    }
    
}
