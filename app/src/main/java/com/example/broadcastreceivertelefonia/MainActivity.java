package com.example.broadcastreceivertelefonia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;

import com.example.broadcastreceivertelefonia.receivers.MiBroadcastReceiver;

public class MainActivity extends AppCompatActivity {
    EditText txtNumero;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNumero= findViewById(R.id.txtNumero);

        findViewById(R.id.btnAceptar).setOnClickListener(v->{
            SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref",MODE_PRIVATE);
            SharedPreferences.Editor myEdit = sharedPreferences.edit();
            myEdit.putString("numero", txtNumero.getText().toString());
            myEdit.commit();
        });
    }



}