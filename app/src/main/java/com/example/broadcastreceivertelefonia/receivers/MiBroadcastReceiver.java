package com.example.broadcastreceivertelefonia.receivers;

import static android.content.Context.MODE_PRIVATE;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

public class MiBroadcastReceiver extends BroadcastReceiver {



    @Override
    public void onReceive(Context context, Intent intent) {
        SharedPreferences sh = context.getSharedPreferences("MySharedPref", MODE_PRIVATE);
        String numero = sh.getString("numero","");

        String action = intent.getAction();

        if (action.equals(android.telephony.TelephonyManager.ACTION_PHONE_STATE_CHANGED)) {
           // Toast.makeText(context, "Llamada recibida", Toast.LENGTH_SHORT).show();
           Toast.makeText(context, "Numero"+numero,Toast.LENGTH_SHORT );
        }

    }



    private void enviarSMS() {

    }
}
