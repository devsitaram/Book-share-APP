package com.sitaram.bookshare.features.slider;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.bookshare.R;

@SuppressLint("CustomSplashScreen")
public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        // use the postDelayed
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(SplashScreenActivity.this, SliderActivity.class);
            startActivity(intent);
            finish();
        }, 1000);
    }
}