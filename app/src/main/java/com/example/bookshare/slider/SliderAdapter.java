package com.example.bookshare.slider;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.bookshare.R;

public class SliderAdapter extends PagerAdapter {

    Context context;
    int image[] = {
            R.mipmap.img_slider_first,
            R.mipmap.img_slider_second,
            R.mipmap.img_slider_third,
    };
    int description[] = {
            R.string.tv_first_description,
            R.string.tv_second_description,
            R.string.tv_third_description,
    };

    SliderAdapter(Context context){
        this.context = context;
    }
    @Override
    public int getCount() {
        return image.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (LinearLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position){
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        @SuppressLint("ResourceType")
        View view = layoutInflater.inflate(R.id.sliderViewPager, container, false);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        ImageView sliderImage =  view.findViewById(R.id.ivSliderImage);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        TextView textViewDescription = view.findViewById(R.id.tvSliderDescribtion);

        sliderImage.setImageResource(image[position]);
        textViewDescription.setText(description[position]);

        container.addView(view);


        return view;
    }

    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object){
        container.removeView((LinearLayout) object);
    }
}
