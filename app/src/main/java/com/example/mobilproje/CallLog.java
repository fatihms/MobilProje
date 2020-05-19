package com.example.mobilproje;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.widget.Toast;

public class CallLog extends BroadcastReceiver {
    String sPhoneNumber, sState, message;

    @Override
    public void onReceive(Context context, Intent intent) {
        sState = intent.getStringExtra(TelephonyManager.EXTRA_STATE);
        message = "State: " + sState;

        if (TelephonyManager.EXTRA_STATE_RINGING.equals(sState)) {
            sPhoneNumber = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);
            message += ". Arayan numara " + sPhoneNumber;

            Toast.makeText(context, message, Toast.LENGTH_LONG).show();
            Toast.makeText(context, message, Toast.LENGTH_LONG).show();
        }

    }

}
