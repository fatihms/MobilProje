package com.example.mobilproje;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

import java.util.Date;

public class SMSLog extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED")) {

            Bundle bundle = intent.getExtras();

            Object[] pduArr = (Object[]) bundle.get("pdus");

            SmsMessage[] messages = new SmsMessage[pduArr.length];
            for (int i = 0; i < pduArr.length; i++) {
                messages[i] = SmsMessage.createFromPdu((byte[]) pduArr[i]);

                Date messageTime = new Date(System.currentTimeMillis());

                String str = " Gönderen: " + messages[i].getDisplayOriginatingAddress() + "\nMesaj: " + messages[i].getMessageBody() + "\nTarih:" + messageTime;
                Toast.makeText(context, str, Toast.LENGTH_LONG).show();
            }
        }
    }

}
