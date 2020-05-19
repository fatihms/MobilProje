package com.example.mobilproje;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class SendLocation extends AppCompatActivity {

    Button btnGetLocation, btnSendLocation;
    TextView tvGetLatitude, tvGetLongitude, tvGetCountryName, tvGetLocality, tvGetAddressLine;
    FusedLocationProviderClient fusedLocationProviderClient;
    String sLatitude, sLongitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_location);

        btnGetLocation = findViewById(R.id.btn_getLocation);
        btnSendLocation = findViewById(R.id.btn_sendLocation);
        tvGetLatitude = findViewById(R.id.tv_getLatitude);
        tvGetLongitude = findViewById(R.id.tv_getLongitude);
        tvGetCountryName = findViewById(R.id.tv_getCountryName);
        tvGetLocality = findViewById(R.id.tv_getLocality);
        tvGetAddressLine = findViewById(R.id.tv_getAddressLine);

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);

        btnSendLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                String shareBody = "http://www.google.com/maps/place/" +
                        sLatitude + "," + sLongitude;
                String shareSub = "f";

                shareIntent.putExtra(Intent.EXTRA_SUBJECT, shareSub);
                shareIntent.putExtra(Intent.EXTRA_TEXT, shareBody);

                startActivity(Intent.createChooser(shareIntent, "Paylaş"));
            }
        });

        btnGetLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ActivityCompat.checkSelfPermission(SendLocation.this
                        , Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                    getLocation();
                } else {
                    ActivityCompat.requestPermissions(SendLocation.this
                            , new String[]{
                                    Manifest.permission.ACCESS_FINE_LOCATION
                            }, 44);
                }
            }
        });
    }

    private void getLocation() {

        fusedLocationProviderClient.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
            @Override
            public void onComplete(@NonNull Task<Location> task) {
                Location location = task.getResult();
                if (location != null) {
                    try {
                        Geocoder geocoder = new Geocoder(SendLocation.this,
                                Locale.getDefault());
                        List<Address> address = geocoder.getFromLocation(
                                location.getLatitude(), location.getLongitude(), 1
                        );
                        sLatitude = " " + address.get(0).getLatitude();
                        sLongitude = " " + address.get(0).getLongitude();
                        tvGetLatitude.setText("" + address.get(0).getLatitude());
                        tvGetLongitude.setText("" + address.get(0).getLongitude());
                        tvGetCountryName.setText("" + address.get(0).getCountryName());
                        tvGetLocality.setText("" + address.get(0).getLocality());
                        tvGetAddressLine.setText("" + address.get(0).getAddressLine(0));

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

    }
}
