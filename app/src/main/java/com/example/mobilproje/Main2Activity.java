package com.example.mobilproje;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    ImageButton btnSendMail, btnUserList, btnNotepad, btnSetting, btnSensorTest,
            btnSensorList, btnAlarm, btnRdmProgress, btnSendLocation, btnMotion;
    ImageView ivProfile;
    TextView txtUserName;
    int userID;
    Users usersClass;
    String[][] users;
    int[][] usersIMG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        usersClass = new Users();
        users = usersClass.users;
        usersIMG = usersClass.usersImage;

        Intent intent = getIntent();
        userID = intent.getIntExtra("userID", 99);
        txtUserName = findViewById(R.id.txt_userName);
        txtUserName.setText(users[userID][0]);
        ivProfile = findViewById(R.id.iv_profile);
        ivProfile.setImageResource(usersIMG[userID][1]);

        btnSendMail = findViewById(R.id.btn_sendMail);
        btnUserList = findViewById(R.id.btn_userList);
        btnNotepad = findViewById(R.id.btn_notepad);
        btnSetting = findViewById(R.id.btn_settings);
        btnSensorList = findViewById(R.id.btn_sensorList);
        btnSensorTest = findViewById(R.id.btn_sensorTest);
        btnAlarm = findViewById(R.id.btn_alarm);
        btnRdmProgress = findViewById(R.id.btn_rdmProgress);
        btnSendLocation = findViewById(R.id.btn_sndLocation);
        btnMotion = findViewById(R.id.btn_motion);

        clickButtons();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.btn_sendMail:
                Intent intentSendMail = new Intent(Main2Activity.this, Main3Activity.class);
                startActivity(intentSendMail);
                break;
            case R.id.btn_userList:
                Intent intentUserList = new Intent(Main2Activity.this, Main6Activity.class);
                startActivity(intentUserList);
                break;
            case R.id.btn_notepad:
                Intent intentNotepad = new Intent(Main2Activity.this, Main8Activity.class);
                startActivity(intentNotepad);
                break;
            case R.id.btn_settings:
                Intent intentSettings = new Intent(Main2Activity.this, Main9Activity.class);
                startActivity(intentSettings);
                break;
            case R.id.btn_sensorList:
                Intent intentSensorList = new Intent(Main2Activity.this, Main5Activity.class);
                startActivity(intentSensorList);
                break;
            case R.id.btn_sensorTest:
                Intent intentSensorTest = new Intent(Main2Activity.this, Main7Activity.class);
                startActivity(intentSensorTest);
                break;
            case R.id.btn_alarm:
                Intent intentAlarm = new Intent(Main2Activity.this, AlarmActivity.class);
                startActivity(intentAlarm);
                break;
            case R.id.btn_rdmProgress:
                Intent intentProgress = new Intent(Main2Activity.this, ProgressBarActivity.class);
                startActivity(intentProgress);
                break;
            case R.id.btn_sndLocation:
                Intent intentSendLocation = new Intent(Main2Activity.this, SendLocation.class);
                startActivity(intentSendLocation);
                break;
            case R.id.btn_motion:
                Intent intentMotion = new Intent(Main2Activity.this, MoveActivity.class);
                startActivity(intentMotion);
                break;
        }
    }

    void clickButtons() {
        btnSendMail.setOnClickListener(this);
        btnUserList.setOnClickListener(this);
        btnNotepad.setOnClickListener(this);
        btnSetting.setOnClickListener(this);
        btnSensorTest.setOnClickListener(this);
        btnSensorList.setOnClickListener(this);
        btnAlarm.setOnClickListener(this);
        btnRdmProgress.setOnClickListener(this);
        btnSendLocation.setOnClickListener(this);
        btnMotion.setOnClickListener(this);
    }


}
