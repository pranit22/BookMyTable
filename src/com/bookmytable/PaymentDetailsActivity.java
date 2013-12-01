package com.bookmytable;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.nfc.NfcEvent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.nio.charset.Charset;

public class PaymentDetailsActivity extends Activity implements NfcAdapter.CreateNdefMessageCallback {

    NfcAdapter mNfcAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_details);

        ((TextView)findViewById(R.id.amount)).setText(getIntent().getStringExtra("amount"));

        final EditText editText1 = (EditText) findViewById(R.id.ccnum1);
        final EditText editText2 = (EditText) findViewById(R.id.ccnum2);
        final EditText editText3 = (EditText) findViewById(R.id.ccnum3);
        final EditText editText4 = (EditText) findViewById(R.id.ccnum4);
        final EditText editText5 = (EditText) findViewById(R.id.cvv);
        final Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
        final Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);

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
                        spinner1.requestFocus();
                        InputMethodManager imm = (InputMethodManager) getSystemService(
                                Context.INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(editText4.getWindowToken(), 0);
                    }
                }
                return false;
            }
        });


    }

    public void paynow(View view) {
        if (checkLength(((EditText) findViewById(R.id.ccnum1)).getText().toString(), 4)
                && checkLength(((EditText) findViewById(R.id.ccnum2)).getText().toString(), 4)
                && checkLength(((EditText) findViewById(R.id.ccnum3)).getText().toString(), 4)
                && checkLength(((EditText) findViewById(R.id.ccnum4)).getText().toString(), 4)
                && checkLength(((EditText) findViewById(R.id.cvv)).getText().toString(), 3)) {

            Toast.makeText(this, "Please tap your device with the tablet to confirm the payment!", Toast.LENGTH_LONG).show();
            mNfcAdapter = NfcAdapter.getDefaultAdapter(this);
            mNfcAdapter.setNdefPushMessageCallback(this, this);
        }
        else {
            Toast.makeText(this, "Please make sure you have filled all the information!", Toast.LENGTH_SHORT).show();
        }
    }

    public void cancel(View view) {
        startActivity(new Intent(this, MenuActivity.class));
    }

    private boolean checkLength(String string, int length) {
        return string != null && string.length() == length;
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
