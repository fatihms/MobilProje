package com.example.mobilproje;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import static android.hardware.Sensor.TYPE_ACCELEROMETER;

public class MoveActivity extends AppCompatActivity implements SensorEventListener {

    SensorManager sensorManager;
    Sensor accelerometer;
    SensorEventListener lightEventListener;
    Context context;
    View root;
    int iCounter;
    float iLastY, iX, iY, iZ;
    TextView tvCounterMotion;

    Boolean move = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move);

        root = findViewById(R.id.root);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        accelerometer = sensorManager.getDefaultSensor(TYPE_ACCELEROMETER);

        tvCounterMotion = findViewById(R.id.tv_counterMotion);

        context = getApplicationContext();
        iCounter = 0;

    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(MoveActivity.this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);

    }

    @Override
    protected void onPause() {
        super.onPause();
    }


    @Override
    public void onSensorChanged(final SensorEvent event) {
        if (event.sensor.getType() == TYPE_ACCELEROMETER) {
            if (event.values[1] != iY) {
                iY = event.values[1];
                iCounter++;
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        tvCounterMotion.setText(" " + iCounter);
                    }


                }, 5000);
            }

        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

}
