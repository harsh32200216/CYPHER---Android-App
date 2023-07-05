package com.example.crypto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Timestamp;
import java.util.ArrayList;

public class Decoder extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText etdec;
    TextView dectv;
    TextView tim;
    ClipboardManager cplboard;
    ArrayList<String> ciphers;
    Spinner spinner;
    ArrayAdapter<String> cipher_adapter;
    int cx = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decoder);

        etdec = findViewById(R.id.etdec);
        dectv = findViewById(R.id.dectv);
        tim = findViewById(R.id.tim2);
        cplboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ciphers = new ArrayList<String>();

        ciphers.add("Select");
        ciphers.add("ScyTale");
        ciphers.add("Mono Alphabetic");
        ciphers.add("Rail Fence");
        ciphers.add("Caeser");

        spinner = findViewById(R.id.spin);
        spinner.setOnItemSelectedListener(this);


        cipher_adapter=new ArrayAdapter<String>(getBaseContext(),android.R.layout.simple_spinner_item, ciphers);
        cipher_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(cipher_adapter);

    }

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
    public void dec(View view){
        String temp = etdec.getText().toString();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        if(cx == 3) {
            String rv = decode.decryptRailFence(temp, 3);
            dectv.setText(rv);
        }
        else if(cx == 1){
            String rv = decode.DecryptScyTale(temp);
            dectv.setText(rv);
        }
        else if(cx == 2){
            String rv = decode.stringMonoDecryption(temp);
            dectv.setText(rv);
        }
        else if(cx == 4){
            String rv = decode.decryptCeaserData(temp,3);
            dectv.setText(rv);
        }
        Timestamp timestamp2 = new Timestamp(System.currentTimeMillis());
        int totalTimeTaken = (int) (timestamp2.getTime() - timestamp.getTime());
        String ttt = Integer.toString(totalTimeTaken);
        tim.setText(ttt + " ms");
    }

    public void cp1(View view){
        String data = dectv.getText().toString().trim();
        if(!data.isEmpty()){
            ClipData temp = ClipData.newPlainText("text",data);
            cplboard.setPrimaryClip(temp);
            Toast.makeText(this,"Copied",Toast.LENGTH_SHORT).show();
        }
    }
}