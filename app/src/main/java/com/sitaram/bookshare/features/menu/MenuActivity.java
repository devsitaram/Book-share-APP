package com.sitaram.bookshare.features.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import com.google.android.material.navigation.NavigationView;
import com.example.bookshare.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.sitaram.bookshare.features.setting.SettingActivity;

public class MenuActivity extends AppCompatActivity {

    FloatingActionButton btnMessage;
    NavigationView btnNavigation;
    @SuppressLint({"MissingInflatedId", "NonConstantResourceId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manu);
        btnNavigation = findViewById(R.id.btnNavicationMenuIcon);
        // this is the bottomNavigationView where click to go the button related pages
        btnNavigation.setNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.navGallery:
                    return true;
                case R.id.navOutBox:
                case R.id.navSlideshow:
                case R.id.navFeedback:
                case R.id.navSetting:
                    startActivity(new Intent(MenuActivity.this, SettingActivity.class));
                    return true;
                case R.id.navHelp:
                default:
                    return false;
            }
        });
    }
}