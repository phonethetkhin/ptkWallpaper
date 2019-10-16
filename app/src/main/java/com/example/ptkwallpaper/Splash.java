package com.example.ptkwallpaper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Splash extends AppCompatActivity {
private final int SPLASH_TIMER=5000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
new Handler().postDelayed(new Runnable() {
    @Override
    public void run() {
Intent i=new Intent(Splash.this,MainActivity.class);
startActivity(i);
finish();
    }
},SPLASH_TIMER);

    }
}
