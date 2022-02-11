package com.example.broadcastreceivertelefonia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.broadcastreceivertelefonia.receivers.MiBroadcastReceiver;

public class MainActivity extends AppCompatActivity {
    EditText txtNumero;
    TextView txtDefinido;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNumero= findViewById(R.id.txtNumero);
        txtDefinido=findViewById(R.id.txtDefinido);

        SharedPreferences sh = this.getSharedPreferences("MiSP", MODE_PRIVATE);
        String numero = sh.getString("numero","");
        txtDefinido.setText(numero);

        findViewById(R.id.btnAceptar).setOnClickListener(v->{

            String num= txtNumero.getText().toString();
            SharedPreferences sharedPreferences = this.getSharedPreferences("MiSP",MODE_PRIVATE);
            SharedPreferences.Editor myEdit = sharedPreferences.edit();

            myEdit.putString("numero",num );
            myEdit.apply();
            txtDefinido.setText(num);
        });



        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS},1);


    }



}