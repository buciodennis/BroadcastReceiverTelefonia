package com.example.broadcastreceivertelefonia.receivers;

import static android.content.Context.MODE_PRIVATE;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

public class MiBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        SharedPreferences sh = context.getSharedPreferences("MiSP", MODE_PRIVATE);
        String numero = sh.getString("numero","0");
        String action = intent.getAction();

        if (action.equals(android.telephony.TelephonyManager.ACTION_PHONE_STATE_CHANGED)&& intent
                .getStringExtra(TelephonyManager.EXTRA_STATE).equals(TelephonyManager.EXTRA_STATE_RINGING)) {

            if(intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER)!=null){
                String numeroEntrante= intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);

                if(numeroEntrante.equals(numero)){
                    Log.d("Numeros:","Coinciden");
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage("4451097898",
                            null,
                            "No puedo contestar ahora",
                            null, null);
                }
            }




        }

    }




}