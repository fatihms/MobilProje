package com.example.mobilproje;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class AlarmActivity extends AppCompatActivity {

    private static final int ALARM_REQUEST_CODE = 0;

    private TimePicker timePicker;
    private Button btnSetAlarm, btnCancelAlarm;

    private PendingIntent curAlarmIntent;
    private AlarmManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);
        timePicker = findViewById(R.id.timePicker);
        btnSetAlarm = findViewById(R.id.btn_setAlarm);
        btnCancelAlarm = findViewById(R.id.btn_cancelAlarm);

        manager = (AlarmManager) getSystemService(ALARM_SERVICE);
        timePicker.setIs24HourView(true);

        btnSetAlarm.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                curAlarmIntent = setAlarm(timePicker.getHour(), timePicker.getMinute());
                btnSetAlarm.setVisibility(View.GONE);
                btnCancelAlarm.setVisibility(View.VISIBLE);
            }
        });

        btnCancelAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (curAlarmIntent != null) {
                    manager.cancel(curAlarmIntent);
                    Toast.makeText(AlarmActivity.this, "Alarm İptal Edildi", Toast.LENGTH_SHORT).show();
                    btnCancelAlarm.setVisibility(View.GONE);
                    btnSetAlarm.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    private PendingIntent setAlarm(int hour, int minute) {
        Intent intent = new Intent(this, AlarmReceiver.class);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, ALARM_REQUEST_CODE,
                intent, PendingIntent.FLAG_CANCEL_CURRENT | PendingIntent.FLAG_ONE_SHOT);

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);

        manager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);

        return pendingIntent;
    }

}