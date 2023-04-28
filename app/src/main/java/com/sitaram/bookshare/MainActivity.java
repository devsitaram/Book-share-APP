package com.sitaram.bookshare;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.example.bookshare.R;
import com.sitaram.bookshare.features.home.HomeFragment;

public class MainActivity extends AppCompatActivity {

    @SuppressLint({"ClickableViewAccessibility", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialize the class and create an object
        HomeFragment homeFragment = new HomeFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.flMainContener, homeFragment).commit();

    }
}