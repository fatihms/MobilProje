package com.example.mobilproje;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;

public class ProgressBarActivity extends AppCompatActivity {

    ProgressBar pb;
    TextView tvPbView;
    Button btn;
    Random random;
    ImageView ivPbView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);

        pb = findViewById(R.id.progressBar);
        tvPbView = findViewById(R.id.tv_pbView);
        btn = findViewById(R.id.btn_randomProgress);
        ivPbView = findViewById(R.id.iv_pbView);

        pb.setVisibility(View.VISIBLE);
        ivPbView.setVisibility(View.INVISIBLE);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyTask task = new MyTask();
                task.execute(100, 1, 2, 3);
                ivPbView.setVisibility(View.INVISIBLE);
            }
        });

    }
    class MyTask extends AsyncTask<Integer, Integer, Void> {
        @Override
        protected Void doInBackground(Integer... integers) {
            try {
                int number = 0;
                while (number <= 100) {
                    random = new Random();
                    number = number + random.nextInt(10) + 1;
                    Thread.sleep(1000);
                    publishProgress(number);
                }
            } catch (Exception e) {

            }
            return null;
        }
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            tvPbView.setText("İşlem Başladı");
            btn.setEnabled(false);
            pb.setVisibility(View.VISIBLE);
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            ivPbView.setVisibility(View.VISIBLE);
            tvPbView.setText("İşlem Bitti");
            btn.setEnabled(true);
            pb.setVisibility(View.INVISIBLE);
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            tvPbView.setText("İşlem Devam Ediyor");
            pb.setProgress(values[0]);
            tvPbView.setText(String.valueOf(values[0]));
        }
    }

}
