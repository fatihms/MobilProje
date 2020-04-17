package com.example.mobilproje;

import android.graphics.Color;
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
import static android.hardware.Sensor.TYPE_LIGHT;

public class Main7Activity extends AppCompatActivity implements SensorEventListener {

    SensorManager sensorManager;
    Sensor lightSensor, accelerometer;
    SensorEventListener lightEventListener;
    View root;
    float maxValue;
    TextView tvX, tvY, tvZ;

    Boolean move = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

        tvX = findViewById(R.id.x);
        tvY = findViewById(R.id.y);
        tvZ = findViewById(R.id.z);

        root = findViewById(R.id.root);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        accelerometer = sensorManager.getDefaultSensor(TYPE_ACCELEROMETER);
        lightSensor = sensorManager.getDefaultSensor(TYPE_LIGHT);

        maxValue = lightSensor.getMaximumRange();

    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(Main7Activity.this, lightSensor, SensorManager.SENSOR_DELAY_FASTEST);
        sensorManager.registerListener(Main7Activity.this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);

    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(lightEventListener);
    }

    @Override
    public void onSensorChanged(final SensorEvent event) {
        if (event.sensor.getType() == TYPE_LIGHT) {
            float value = event.values[0];
            int newValue1 = (int) (255f * value / maxValue);
            int newValue2 = (int) (255f / value * maxValue);
            root.setBackgroundColor(Color.rgb(newValue1, newValue1, newValue1));
            tvX.setTextColor(Color.rgb(newValue2, newValue2, newValue2));
            tvY.setTextColor(Color.rgb(newValue2, newValue2, newValue2));
            tvZ.setTextColor(Color.rgb(newValue2, newValue2, newValue2));

        }
        if (event.sensor.getType() == TYPE_ACCELEROMETER) {
            tvX.setText("x"+event.values[0]);
            tvY.setText("y"+event.values[1]);
            tvZ.setText("z"+event.values[2]);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                        if(event.values[0] > 0.0 || event.values[0] < 0.0 || event.values[1] < 9.81 || event.values[2] > 0.0 || event.values[2] < 0.0){
                            finish();
                            System.exit(0);
                        }
                }
            },5000);

        }



    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
