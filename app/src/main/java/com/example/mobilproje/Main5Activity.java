package com.example.mobilproje;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Main5Activity extends AppCompatActivity {
ListView listSens;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        listSens = (ListView) findViewById(R.id.list_sensor);
        SensorManager sManager = (SensorManager)this.getSystemService(this.SENSOR_SERVICE);
        List<Sensor> sensorList = sManager.getSensorList(Sensor.TYPE_ALL);

        List<String> sensorNames = new ArrayList();
        for(int i = 0; i<sensorList.size(); i++){
            sensorNames.add(((Sensor)sensorList.get(i)).getName());
        }

        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, sensorNames);
        listSens.setAdapter(itemsAdapter);
    }
}
