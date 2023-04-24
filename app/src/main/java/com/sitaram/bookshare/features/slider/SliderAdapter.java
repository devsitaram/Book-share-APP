package com.sitaram.bookshare.features.slider;

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
    int[] image = {
            R.mipmap.img_slider_first,
            R.mipmap.img_slider_second,
            R.mipmap.img_slider_third,
    };
    int[] description = {
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
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position){
//        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = LayoutInflater.from(context).inflate(R.layout.slider_layout, container, false);
        ImageView sliderImage =  view.findViewById(R.id.ivSliderImage);
        TextView textViewDescription = view.findViewById(R.id.tvSliderDescribtion);

        // set the image and text for next slider page
        sliderImage.setImageResource(image[position]);
        textViewDescription.setText(description[position]);
        container.addView(view);
        return view;
    }

    // this methods can destroy item when complete the items
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object){
        container.removeView((LinearLayout) object);
    }
}
