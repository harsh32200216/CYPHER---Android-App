package com.example.crypto;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.sql.Timestamp;

import java.util.ArrayList;

public class Encoder extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText etenc;
    TextView enctv;
    TextView tim;
    ClipboardManager cpb;
    ArrayList<String> ciphers;
    Spinner spinner;
    ArrayAdapter<String> cipher_adapter;
    int cx = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encoder);

        etenc = findViewById(R.id.etenc);
        enctv = findViewById(R.id.enctv);
        tim = findViewById(R.id.tim);
        cpb = (ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
        ciphers = new ArrayList<String>();

        ciphers.add("Select");
        ciphers.add("ScyTale");
        ciphers.add("Mono Alphabetic");
        ciphers.add("Rail Fence");
        ciphers.add("Caeser");

        spinner = (Spinner) findViewById(R.id.spinn);
        spinner.setOnItemSelectedListener(this);


        cipher_adapter=new ArrayAdapter<String>(getBaseContext(),android.R.layout.simple_spinner_item, ciphers);
        cipher_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(cipher_adapter);

    }

   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }*/

    @Override
    public void onItemSelected(AdapterView<?> arg0, View v, int position,
                               long arg3) {
        // TODO Auto-generated method stub


        if(!(spinner.getSelectedItem().toString().trim().equals("Select")))
        {
            if (spinner.getSelectedItem().toString().trim().equals("ScyTale")) {
                cx = 1;
            }
            else if (spinner.getSelectedItem().toString().trim().equals("Mono Alphabetic")) {
                cx = 2;
            }
            else if (spinner.getSelectedItem().toString().trim().equals("Rail Fence")) {
                cx = 3;
            }
            else if (spinner.getSelectedItem().toString().trim().equals("Caeser")) {
                cx = 4;
            }
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub

    }

    public void enc(View view){
        String temp = etenc.getText().toString();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        if(cx == 3) {
            String rv = encode.encryptRailFence(temp, 3);
            enctv.setText(rv);
        }
        else if(cx == 1){
            String rv = encode.EncryptScyTale(temp);
            enctv.setText(rv);
        }
        else if(cx == 2){
            String rv = encode.stringMonoEncryption(temp);
            enctv.setText(rv);
        }
        else if(cx == 4){
            String rv = encode.encryptCeaserData(temp, 3);
            enctv.setText(rv);
        }
        Timestamp timestamp2 = new Timestamp(System.currentTimeMillis());
        int totalTimeTaken = (int) (timestamp2.getTime() - timestamp.getTime());
        String ttt = Integer.toString(totalTimeTaken);
        tim.setText(ttt + " ms");
    }

    public void cp2(View view){
        String data = enctv.getText().toString().trim();
        if(!data.isEmpty()){
            ClipData temp = ClipData.newPlainText("text",data);
            cpb.setPrimaryClip(temp);
            Toast.makeText(this,"copied", Toast.LENGTH_LONG).show();

        }
    }
}