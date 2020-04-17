package com.example.mobilproje;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main4Activity extends AppCompatActivity {

     EditText etNoteText;
     TextView tvNote;
     Button btnAdd, btnLoad, btnClear;
     SharedPreferences sp;
     SharedPreferences.Editor ed;
     String note;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        etNoteText = findViewById(R.id.et_noteText);
        btnAdd = findViewById(R.id.btn_noteAdd);
        btnLoad = findViewById(R.id.btn_load);
        btnClear = findViewById(R.id.btn_clear);
        tvNote = findViewById(R.id.tv_note);


        sp = getSharedPreferences("notes", Context.MODE_PRIVATE);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ed = sp.edit();
                ed.putString(note, etNoteText.getText().toString());
                ed.apply();
            }

        });

        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sp.contains(note))
                    tvNote.setText(sp.getString(note,""));
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvNote.setText(" ");
                ed.remove(note);
                ed.apply();
            }
        });

    }


}
