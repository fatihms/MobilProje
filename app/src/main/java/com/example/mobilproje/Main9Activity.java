package com.example.mobilproje;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class Main9Activity extends AppCompatActivity {

    EditText etUserNameSetting, etSizeSetting, etKiloSetting, etAgeSetting;
    RadioButton rbMaleSetting, rbFemaleSetting, rbDarkSetting, rbLightSetting;
    Button btnReadSetting, btnUpdateSetting;
    SharedP preference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);

        btnReadSetting = findViewById(R.id.btn_readSetting);
        btnUpdateSetting = findViewById(R.id.btn_updateSetting);

        etUserNameSetting = findViewById(R.id.et_userNameSetting);
        etSizeSetting = findViewById(R.id.et_sizeSetting);
        etKiloSetting = findViewById(R.id.et_kiloSetting);
        etAgeSetting = findViewById(R.id.et_ageSetting);

        rbMaleSetting = findViewById(R.id.rb_maleSetting);
        rbFemaleSetting = findViewById(R.id.rb_femaleSetting);
        rbDarkSetting = findViewById(R.id.rb_darkSetting);
        rbLightSetting = findViewById(R.id.rb_lightSetting);

        preference = new SharedP();

        btnReadSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etUserNameSetting.setText(preference.getStringValue(getApplicationContext(),"UserNameSetting",""));
                etSizeSetting.setText(preference.getStringValue(getApplicationContext(),"SizeSetting",""));
                etKiloSetting.setText(preference.getStringValue(getApplicationContext(),"KiloSetting",""));
                etAgeSetting.setText(preference.getStringValue(getApplicationContext(),"AgeSetting",""));
                rbMaleSetting.setChecked(preference.getBoolValue(getApplicationContext(),"MaleSetting",false));
                rbFemaleSetting.setChecked(preference.getBoolValue(getApplicationContext(),"FemaleSetting",false));
                rbDarkSetting.setChecked(preference.getBoolValue(getApplicationContext(),"DarkSetting",false));
                rbLightSetting.setChecked(preference.getBoolValue(getApplicationContext(),"LightSetting",false));

            }
        });

        btnUpdateSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedP pref = new SharedP();
                pref.putStringValue(getApplicationContext(),"UserNameSetting",etUserNameSetting.getText().toString());
                pref.putStringValue(getApplicationContext(),"SizeSetting",etSizeSetting.getText().toString());
                pref.putStringValue(getApplicationContext(),"KiloSetting",etKiloSetting.getText().toString());
                pref.putStringValue(getApplicationContext(),"AgeSetting",etAgeSetting.getText().toString());
                pref.putBoolValue(getApplicationContext(),"MaleSetting",rbMaleSetting.isChecked());
                pref.putBoolValue(getApplicationContext(),"FemaleSetting",rbFemaleSetting.isChecked());
                pref.putBoolValue(getApplicationContext(),"DarkSetting",rbDarkSetting.isChecked());
                pref.putBoolValue(getApplicationContext(),"LightSetting",rbLightSetting.isChecked());
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.settings:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
