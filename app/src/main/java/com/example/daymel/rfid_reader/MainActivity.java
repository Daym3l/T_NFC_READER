package com.example.daymel.rfid_reader;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.tapadoo.alerter.Alerter;

import iammert.com.library.Status;
import iammert.com.library.StatusView;

import static com.example.daymel.rfid_reader.R.id.status;

public class MainActivity extends AppCompatActivity {

    private NfcAdapter nfcAdapter;
    PendingIntent pendingIntent;
    TextView textViewInfo;
    IntentFilter writeTagFilters[];
    IntentFilter tag;
    StatusView statusView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewInfo = (TextView) findViewById(R.id.info);
        Button alert = (Button) findViewById(R.id.button);
        statusView = (StatusView) findViewById(R.id.status);
        statusView.setStatus(Status.LOADING);




        alert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!Alerter.isShowing()){
                    statusView.setStatus(Status.COMPLETE);
                    Alerter.create(MainActivity.this)
                            .setTitle("probando")
                            .setText("Esto es la leche...")
                            .show();
                }else {
                    Alerter.hide();
                    statusView.setStatus(Status.IDLE);
                }
            }
        });

      /*  nfcAdapter = NfcAdapter.getDefaultAdapter(this);
        if (nfcAdapter == null) {
            Toast.makeText(this,
                    "NFC no soportado en este dispositivo",
                    Toast.LENGTH_LONG).show();
            finish();
        } else if (!nfcAdapter.isEnabled()) {
            Toast.makeText(this,
                    "NFC no habilitado",
                    Toast.LENGTH_LONG).show();
            finish();
        }
        resolveIntent(getIntent());

        pendingIntent = PendingIntent.getActivity(this, 0, new Intent(this, this.getClass()).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP), 0);
       tag = new IntentFilter(NfcAdapter.ACTION_TAG_DISCOVERED);
        tag.addCategory(Intent.CATEGORY_DEFAULT);
        writeTagFilters = new IntentFilter[]{tag};
*/

    }

    /*@Override
    protected void onNewIntent(Intent intent) {
        setIntent(intent);
        resolveIntent(intent);
        if(NfcAdapter.ACTION_TAG_DISCOVERED.equals(intent.getAction())){
            Tag myTag = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        nfcAdapter.enableForegroundDispatch(this, pendingIntent, writeTagFilters, null);

    }

    @Override
    public void onPause(){
        super.onPause();
       nfcAdapter.disableForegroundDispatch(this);   }



    private void resolveIntent(Intent intent) {
        String action = intent.getAction();
        Log.e("NFC", action);

       *//* if (NfcAdapter.ACTION_TAG_DISCOVERED.equals(action)
                || NfcAdapter.ACTION_TECH_DISCOVERED.equals(action)
                || NfcAdapter.ACTION_NDEF_DISCOVERED.equals(action)) {
            Parcelable[] rawMsgs = intent.getParcelableArrayExtra(NfcAdapter.EXTRA_NDEF_MESSAGES);
            NdefMessage[] msgs;

            if (rawMsgs != null) {
                msgs = new NdefMessage[rawMsgs.length];

                for (int i = 0; i < rawMsgs.length; i++) {
                    msgs[i] = (NdefMessage) rawMsgs[i];
                }

            } else {
                byte[] empty = new byte[0];
                byte[] id = intent.getByteArrayExtra(NfcAdapter.EXTRA_ID);
                Tag tag = (Tag) intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);
                byte[] payload = dumpTagData(tag).getBytes();
                NdefRecord record = new NdefRecord(NdefRecord.TNF_UNKNOWN, empty, id, payload);
                NdefMessage msg = new NdefMessage(new NdefRecord[] {record});
                msgs = new NdefMessage[] {msg};
            }

            displayMsgs(msgs);
        }*//*
    }*/
}
