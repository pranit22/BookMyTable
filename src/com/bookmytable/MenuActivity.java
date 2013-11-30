package com.bookmytable;

import android.app.Activity;
import android.content.Intent;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.nfc.NfcAdapter.CreateNdefMessageCallback;
import android.nfc.NfcEvent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bookmytable.application.BookMyTable;

import java.nio.charset.Charset;

public class MenuActivity extends Activity implements CreateNdefMessageCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        TextView username = (TextView) findViewById(R.id.username);
        BookMyTable bookMyTable = (BookMyTable) getApplicationContext();
        if (bookMyTable.getLoggedInUser() == null) {
            username.setText("Welcome, Guest");
            Button button = (Button) findViewById(R.id.button2);
            ((LinearLayout) button.getParent()).removeView(button);
        } else {
            username.setText("Welcome, " + bookMyTable.getLoggedInUser().getName());
        }

        NfcAdapter mNfcAdapter = NfcAdapter.getDefaultAdapter(this);
        mNfcAdapter.setNdefPushMessageCallback(this, this);
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


    public void checkin(View view) {
        Toast.makeText(this, "Please tap your device with the tablet in order to check-in!", Toast.LENGTH_LONG).show();
    }

    @Override
    public NdefMessage createNdefMessage(NfcEvent event) {
        BookMyTable bookMyTable = (BookMyTable) getApplicationContext();
        String username;
        if (bookMyTable.getLoggedInUser() == null) {
            username = "Guest";
        }
        else {
            username = bookMyTable.getLoggedInUser().getName();
        }
        NdefMessage msg = new NdefMessage(
                new NdefRecord[]{createMimeRecord(
                        "application/com.tabletbookmytable.username", username.getBytes())
                        , NdefRecord.createApplicationRecord("com.tabletbookmytable")
                });
        return msg;
    }

    public NdefRecord createMimeRecord(String mimeType, byte[] payload) {
        byte[] mimeBytes = mimeType.getBytes(Charset.forName("USASCII"));
        NdefRecord mimeRecord = new NdefRecord(NdefRecord.TNF_MIME_MEDIA,
                mimeBytes, new byte[0], payload);
        return mimeRecord;
    }

}
