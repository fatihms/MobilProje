package com.example.mobilproje;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.widget.Toast;


public class AlarmReceiver extends BroadcastReceiver {

    private MediaPlayer player;

    @Override
    public void onReceive(Context context, Intent intent) {
        player = MediaPlayer.create(context, R.raw.alarm);
        player.start();
        Toast.makeText(context, "Alarm", Toast.LENGTH_SHORT).show();
    }
}
