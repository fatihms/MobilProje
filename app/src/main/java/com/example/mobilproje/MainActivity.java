package com.example.mobilproje;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{


    EditText txtUserName, txtPassword;
    Button btnLogin;
    String userName;
    Users usersClass;
    String [][] users;
    int i, error, userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        error = 0;

        usersClass = new Users();
        users = usersClass.users;

        txtUserName = (EditText) findViewById(R.id.et_inputUserName);
        txtPassword = (EditText) findViewById(R.id.et_inputPassword);
        btnLogin = (Button) findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(txtUserName.getText().toString()) || (TextUtils.isEmpty(txtPassword.getText().toString()))){
                    Toast.makeText(MainActivity.this,"Alanlar boş olamaz", Toast.LENGTH_LONG).show();
                }else if(loginControl(txtUserName, txtPassword)){
                        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                        intent.putExtra("userID",userID);
                        startActivity(intent);
                }else{
                    if(error == 2){
                        Toast.makeText(MainActivity.this,"Üç kez yanlış girdiniz, program sonlanıyor.", Toast.LENGTH_LONG).show();
                        System.exit(0);
                    }else {
                        Toast.makeText(MainActivity.this,"Kullanıcı adı veya parola  hatalı.", Toast.LENGTH_LONG).show();
                        error++;
                    }
                }
            }
        });
    }


    public boolean loginControl(EditText p_userName, EditText p_password){
        i = 0;
        while(i < users.length){
            if(p_userName.getText().toString().equals(users[i][0])){
                if(p_password.getText().toString().equals(users[i][1])){
                    userName = users[i][0];
                    userID = i;
                    return true;
                }else{

                    return false;
                }
            }
            i++;
        }
        return false;
    }
}