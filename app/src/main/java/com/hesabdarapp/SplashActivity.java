package com.hesabdarapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {
    Timer timer;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        timer= new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                sharedPreferences=SplashActivity.this.getSharedPreferences("home", Context.MODE_PRIVATE);
                String userName= sharedPreferences.getString("userName","");
                if(userName.equals("")){
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                }else{
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                }

                timer.cancel();
                finish();
            }
        },1500,1000);

    }
}
