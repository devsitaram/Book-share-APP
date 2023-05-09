package com.sitaram.bookshare.features.tv;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.bookshare.R;
import com.google.android.material.tabs.TabLayout;

public class ProductActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        // set onClickListener
        tabLayout.setupWithViewPager(viewPager);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPagerAdapter.addFragment(new F1Fragment(),"F1");
        viewPagerAdapter.addFragment(new F2Fragment(),"F1");
        viewPagerAdapter.addFragment(new F3Fragment(),"F1");
        viewPager.setAdapter(viewPagerAdapter);
    }
}