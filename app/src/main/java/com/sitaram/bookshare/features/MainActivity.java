package com.sitaram.bookshare.features;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.bookshare.R;
import com.sitaram.bookshare.features.about.AboutFragment;
import com.sitaram.bookshare.features.contact.ContactFragment;
import com.sitaram.bookshare.features.menu.MenuActivity;
import com.sitaram.bookshare.features.menu.MenuFragment;
import com.sitaram.bookshare.features.product.ProductFragment;
import com.sitaram.bookshare.features.home.HomeFragment;
import com.sitaram.bookshare.features.profile.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    // initialize the class and create an object
    HomeFragment homeFragment = new HomeFragment();
    ProfileFragment profileFragment = new ProfileFragment();
    ProductFragment productFragment = new ProductFragment();
    ContactFragment contactFragment = new ContactFragment();
    AboutFragment aboutFragment = new AboutFragment();
    BottomNavigationView bottomNavigationView;
    @SuppressLint({"ClickableViewAccessibility", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.btnNavicationIcon);

        // already show the apps fragment class
        getSupportFragmentManager().beginTransaction().replace(R.id.flMainContener, homeFragment).commit();
        // this is the bottomNavigationView where click to go the button related pages
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navBtnHome:
                        // go to the home fragment class
                        getSupportFragmentManager().beginTransaction().replace(R.id.flMainContener, homeFragment).commit();
                        return true;
                    case R.id.navBtnProfile:
                        // go to the profile fragment class
                        getSupportFragmentManager().beginTransaction().replace(R.id.flMainContener, profileFragment).commit();
                        return true;
                    case R.id.navBtnProduct:
                        // go to the product fragment class
                        getSupportFragmentManager().beginTransaction().replace(R.id.flMainContener, productFragment).commit();
                        return true;
                    case R.id.navBtnContact:
                        // go to the contract fragment class
                        getSupportFragmentManager().beginTransaction().replace(R.id.flMainContener, contactFragment).commit();
                        return true;
                    case R.id.navBtnAbout:
                        // go to the about fragment class
                        getSupportFragmentManager().beginTransaction().replace(R.id.flMainContener, aboutFragment).commit();
                        return true;
                    default:
                        return false;
                }
            }
        });
    }

    // create a toastMassage method which accept the String parameter
    public void toastMassage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}