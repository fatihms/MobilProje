package com.example.mobilproje;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main8Activity extends AppCompatActivity {

    EditText etfileName, etfileMessage;
    Button btnfileSave, btnfileDelete, btnfileRead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);

        etfileMessage = findViewById(R.id.et_fileMessage);
        etfileName = findViewById(R.id.et_fileName);
        btnfileSave = findViewById(R.id.btn_fileSave);
        btnfileRead = findViewById(R.id.btn_fileRead);
        btnfileDelete = findViewById(R.id.btn_fileDelete);

        //save
        btnfileSave.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String filename = etfileName.getText().toString();
                String data = etfileMessage.getText().toString();

                FileOutputStream file;
                try {
                    file = openFileOutput(filename, Context.MODE_PRIVATE);
                    file.write(data.getBytes());
                    file.close();

                    Toast.makeText(getApplicationContext(), filename + " kaydedildi",
                            Toast.LENGTH_LONG).show();

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        });

        //read
        btnfileRead.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String filename = etfileName.getText().toString();


                StringBuffer stringBuffer = new StringBuffer();
                try {
                    BufferedReader inputReader = new BufferedReader(new InputStreamReader(
                            openFileInput(filename)));
                    String inputString;
                    while ((inputString = inputReader.readLine()) != null) {
                        stringBuffer.append(inputString + "\n");
                    }
                    etfileMessage.setText(stringBuffer);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        });

        //Delete
        btnfileDelete.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                String filename = etfileName.getText().toString();

                deleteFile(filename);
                Toast.makeText(getApplicationContext(), filename + " silindi",
                        Toast.LENGTH_LONG).show();
                etfileMessage.setText("");
            }

        });

    }
}