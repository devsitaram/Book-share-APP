package com.sitaram.bookshare.features.slider;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.bookshare.R;
import com.sitaram.bookshare.features.login.LoginActivity;

public class SliderActivity extends AppCompatActivity {

    ViewPager mSliderViewPager;
    LinearLayout mDotLayout;
    TextView btnSkip, btnBack, btnNext;
    TextView[] dots;
    SliderAdapter sliderAdapter;
    SharedPreferences.Editor editor;

    @SuppressLint({"MissingInflatedId", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider);

        // initialize the variable
        btnSkip = findViewById(R.id.tvSliderSkip);
        btnBack = findViewById(R.id.tvSliderBack);
        btnNext = findViewById(R.id.tvSliderNext);
        btnBack.setVisibility(View.INVISIBLE);

        // SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("SelfPrefs", MODE_PRIVATE);
        boolean hasViewedSlider = sharedPreferences.getBoolean("has_viewed_slider", false);

        if (hasViewedSlider) {
            startActivity(new Intent(SliderActivity.this, LoginActivity.class));
            finish();
        } else {
            // skip button
            btnSkip.setOnClickListener(v -> {
                startActivity(new Intent(SliderActivity.this, LoginActivity.class));
                finish();
            });

            // back button
            btnBack.setOnClickListener(v -> {
                if (getItem(0) > 0) {
                    mSliderViewPager.setCurrentItem(getItem(-1), true);
                }
            });

            // next button
            btnNext.setOnClickListener(v -> {
                if (getItem(0) < 2) {
                    mSliderViewPager.setCurrentItem(getItem(1), true);
                } else {
                    startActivity(new Intent(SliderActivity.this, LoginActivity.class));
                    finish();
                }
            });

            // initialize the mSliderViewPager and mDotLayout
            mSliderViewPager = findViewById(R.id.sliderViewPager);
            mDotLayout = findViewById(R.id.indicator_layout);
            // create an object of sliderAdapter and call the setAdapter methods
            sliderAdapter = new SliderAdapter(this);
            mSliderViewPager.setAdapter(sliderAdapter);

            setUpIndicator(0);// call this method where it is accept the one integer parameter
            mSliderViewPager.addOnPageChangeListener(viewListener);

            // Save the preference to indicate that the user has viewed the slider screen
            editor = sharedPreferences.edit();
            editor.putBoolean("has_viewed_slider", true);
            editor.apply();
        }
    }

    public void setUpIndicator(int position) {
        dots = new TextView[3];
        mDotLayout.removeAllViews();

        // using the for loop
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText("\u2022");
            dots[i].setTextSize(35);
            dots[i].setTextColor(getResources().getColor(R.color.inactive, getApplicationContext().getTheme()));
            mDotLayout.addView(dots[i]);
        }
        // setTextColor for slider position
        dots[position].setTextColor(getResources().getColor(R.color.active, getApplicationContext().getTheme()));
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            // the user is scrolling through the ViewPager
        }

        @SuppressLint("SetTextI18n")
        @Override
        public void onPageSelected(int position) {
            setUpIndicator(position);
            if (position > 0) {
                btnBack.setVisibility(View.VISIBLE);
            } else {
                btnBack.setVisibility(View.INVISIBLE);
            }
            if (position == 2) {
                btnNext.setText("Start");
            } else {
                btnNext.setText("Next");
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {
        }
    };

    // count the slider item
    private int getItem(int item) {
        return mSliderViewPager.getCurrentItem() + item;
    }
}