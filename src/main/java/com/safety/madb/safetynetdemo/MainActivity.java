package com.safety.madb.safetynetdemo;

import android.support.v7.app.AppCompatActivity;

import com.safety.madb.safetynetimp.SafetyNetImpl;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements SafetyNetImpl.onCallbackSafetyNet {

    TextView txt;
    SafetyNetImpl sf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = (TextView) findViewById(R.id.text1);
        sf = new SafetyNetImpl(getApplicationContext(), this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        sf.start();
    }


    @Override
    public void onMessage(String msg) {
        Toast.makeText(MainActivity.this, msg.toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResult(boolean res) {
        txt.setText(res + " ");
    }

    @Override
    public void onError(String err) {
        Toast.makeText(MainActivity.this, "Error: " + err, Toast.LENGTH_SHORT).show();
    }
}
