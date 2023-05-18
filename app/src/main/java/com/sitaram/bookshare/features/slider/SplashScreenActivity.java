package com.sitaram.bookshare.features.slider;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bookshare.R;
import com.sitaram.bookshare.features.firebase.FirebaseInstanceNotificationService;

@SuppressLint("CustomSplashScreen")
public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        // notification
        FirebaseInstanceNotificationService notificationService = new FirebaseInstanceNotificationService();
        notificationService.notification();
        // use the postDelayed
        new Handler().postDelayed(() -> {
            Intent intentSlider = new Intent(SplashScreenActivity.this, SliderActivity.class);
            startActivity(intentSlider);
            finish();
        }, 1500);
    }
}