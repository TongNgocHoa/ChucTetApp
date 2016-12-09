package com.laptrinhdao.chuctetapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.laptrinhdao.chuctetapp.MainActivity;
import com.laptrinhdao.chuctetapp.R;

public class SplashScreen extends AppCompatActivity {
    private static int Timer = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplication(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        },Timer);
    }
}
