package com.sitaram.bookshare.features.menu;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bookshare.R;
import com.google.android.material.navigation.NavigationView;
import com.sitaram.bookshare.features.home.HomeFragment;
import com.sitaram.bookshare.features.setting.SettingActivity;

public class MenuActivity extends AppCompatActivity {

    NavigationView btnNavigation;
    Button btnGoBack;
    @SuppressLint({"MissingInflatedId", "NonConstantResourceId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manu);
        btnGoBack = findViewById(R.id.btnGoBackMenuToHome);
        btnNavigation = findViewById(R.id.btnNavicationMenuIcon);

        btnGoBack.setOnClickListener(v -> {
            HomeFragment homeFragment = new HomeFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.flMainContener, homeFragment).commit();
        });
        // this is the bottomNavigationView where click to go the button related pages
        btnNavigation.setNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.navGallery:
                    return true;
                case R.id.navOutBox:
                    return true;
                case R.id.navSlideshow:
                    return true;
                case R.id.navFeedback:
                    return true;
                case R.id.navSetting:
                    startActivity(new Intent(MenuActivity.this, SettingActivity.class));
                    finish();
                    return true;
                case R.id.navHelp:
                    return true;
                default:
                    return false;
            }
        });
    }
}