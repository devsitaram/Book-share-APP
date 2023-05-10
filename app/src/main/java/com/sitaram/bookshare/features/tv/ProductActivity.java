package com.sitaram.bookshare.features.tv;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.bookshare.R;
import com.google.android.material.tabs.TabLayout;

public class ProductActivity extends AppCompatActivity {

    // Initialize variables
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        // assign variable
//        tabLayout = findViewById(R.id.tabLayout);
//        viewPager = findViewById(R.id.viewPager);
//
//        tabLayout.setupWithViewPager(viewPager);
//        // create an view pager adapter and set the different fragment page
//        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
//        viewPagerAdapter.addFragment(new ForYouBookFragment(), "For You");
//        viewPagerAdapter.addFragment(new TrendingBookFragment(), "Hello");
//        // set the view pager adapter in view pager
//        viewPager.setAdapter(viewPagerAdapter);
    }
}