package com.example.broadcastreceivertelefonia.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

public class MiBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();

        if (action.equals(android.telephony.TelephonyManager.ACTION_PHONE_STATE_CHANGED)) {
            String incomingNumber = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);
            Log.d("Llamada", "Received call: " + incomingNumber);
            Toast.makeText(context, "Llamada recibida", Toast.LENGTH_SHORT).show();
        }

    }
}
