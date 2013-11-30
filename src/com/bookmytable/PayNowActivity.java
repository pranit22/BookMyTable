package com.bookmytable;

import android.app.Activity;
import android.content.Intent;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.nfc.NfcEvent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.bookmytable.application.BookMyTable;

import java.nio.charset.Charset;

public class PayNowActivity extends Activity implements NfcAdapter.CreateNdefMessageCallback {

    NfcAdapter mNfcAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_now);

        mNfcAdapter = NfcAdapter.getDefaultAdapter(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        // Check to see that the Activity started due to an Android Beam
        if (NfcAdapter.ACTION_NDEF_DISCOVERED.equals(getIntent().getAction())) {
            processIntent(getIntent());
        }
    }

    @Override
    public void onNewIntent(Intent intent) {
        // onResume gets called after this to handle the intent
        setIntent(intent);
    }

    /**
     * Parses the NDEF Message from the intent and prints to the TextView
     */
    void processIntent(Intent intent) {
        Parcelable[] rawMsgs = intent.getParcelableArrayExtra(
                NfcAdapter.EXTRA_NDEF_MESSAGES);
        // only one message sent during the beam
        NdefMessage msg = (NdefMessage) rawMsgs[0];
        // record 0 contains the MIME type, record 1 is the AAR, if present

        String amount = new String(msg.getRecords()[0].getPayload());
        ((TextView) findViewById(R.id.amount)).setText(amount);
    }

    public void paynow(View view) {

        if (((BookMyTable) getApplicationContext()).getLoggedInUser() == null) {
            Intent newIntent = new Intent(this, PaymentDetailsActivity.class);
            newIntent.putExtra("amount",  ((TextView) findViewById(R.id.amount)).getText().toString());
            startActivity(newIntent);
        } else {
            Toast.makeText(this, "Please tap your device with the tablet to confirm the payment!", Toast.LENGTH_LONG).show();
            mNfcAdapter.setNdefPushMessageCallback(this, this);
        }
    }

    public void cancel(View view) {
        startActivity(new Intent(this, MenuActivity.class));
    }

    @Override
    public NdefMessage createNdefMessage(NfcEvent event) {
        String amount = ((TextView) findViewById(R.id.amount)).getText().toString();

        NdefMessage msg = new NdefMessage(
                new NdefRecord[]{createMimeRecord(
                        "application/com.tabletbookmytable.confirm", amount.getBytes())
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
