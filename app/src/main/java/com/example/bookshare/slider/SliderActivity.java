package com.example.bookshare.slider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.bookshare.MainActivity;
import com.example.bookshare.R;
import com.example.bookshare.features.login.LoginActivity;

public class SliderActivity extends AppCompatActivity {

    ViewPager mSliderViewPager;
    LinearLayout mDotLayout;
    Button btnSkip, btnBack, btnNext;

    TextView[] dots;
    SliderAdapter sliderAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider);

        btnSkip = findViewById(R.id.btnSliderSkip);
        btnBack = findViewById(R.id.btnSliderBack);
        btnNext = findViewById(R.id.btnSliderNext);

        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SliderActivity.this, MainActivity.class));
                finish();
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getItem(0)>0){
                    mSliderViewPager.setCurrentItem(getItem(-1), true);
                }
            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getItem(0)<2){
                    mSliderViewPager.setCurrentItem(getItem(1), true);
                } else {
                    startActivity(new Intent(SliderActivity.this, MainActivity.class));
                    finish();
                }
            }
        });

        mSliderViewPager = findViewById(R.id.sliderViewPager);
        mDotLayout = findViewById(R.id.indicator_layout);

        sliderAdapter = new SliderAdapter(this);
        mSliderViewPager.setAdapter(sliderAdapter);

        setUpIndicator(0);// call this method
        mSliderViewPager.addOnPageChangeListener(viewListener);

//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Intent intent = new Intent(SliderActivity.this, LoginActivity.class);
//                startActivity(intent);
//                finish();
//            }
//        }, 3000);
    }

    public void setUpIndicator(int position){
        dots = new TextView[3];
        mDotLayout.removeAllViews();

        for (int i=0; i<dots.length; i++){
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(getResources().getColor(R.color.inactive, getApplicationContext().getTheme()));
            mDotLayout.addView(dots[i]);
        }

        dots[position].setTextColor(getResources().getColor(R.color.active, getApplicationContext().getTheme()));
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            setUpIndicator(position);
            if(position>0){
                btnBack.setVisibility(View.VISIBLE);
            } else {
                btnBack.setVisibility(View.INVISIBLE);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    private  int getItem(int item){
        return mSliderViewPager.getCurrentItem()+item;
    }
}