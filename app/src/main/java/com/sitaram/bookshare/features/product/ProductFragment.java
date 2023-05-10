package com.sitaram.bookshare.features.product;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.bookshare.R;
import com.google.android.material.tabs.TabLayout;
import com.sitaram.bookshare.features.product.firstviewpager.ForYouBookFragment;
import com.sitaram.bookshare.features.product.helper.BookPojo;
import com.sitaram.bookshare.features.product.secondviewpager.TrendingBookFragment;

public class ProductFragment extends Fragment implements ProductContract.View {

    View bookView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        bookView = inflater.inflate(R.layout.fragment_product, container, false);
        // assign variable
        TabLayout tabLayout = bookView.findViewById(R.id.tabLayout);
        ViewPager viewPager = bookView.findViewById(R.id.viewPager);

        tabLayout.setupWithViewPager(viewPager);
        // create an view pager adapter and set the different fragment page
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPagerAdapter.addFragment(new ForYouBookFragment(), "For You");
        viewPagerAdapter.addFragment(new TrendingBookFragment(), "Trending");
//        viewPagerAdapter.addFragment(new FavouriteFragment(), "Favourite");
        // set the view pager adapter in view pager
        viewPager.setAdapter(viewPagerAdapter);
        return bookView;
    }

    @Override
    public void setBooks(BookPojo body) {

    }

    // if the system can be valid perform then show the successMessage with toast message
    @SuppressLint("ShowToast")
    @Override
    public void successMessage(String success) {
        Toast.makeText(getActivity(), success, Toast.LENGTH_LONG);
    }

    // encase the system can be invalid perform then show the errorMessage with toast message
    @Override
    public void errorMessage(String error) {
        Toast.makeText(getActivity(), error, Toast.LENGTH_LONG).show();
    }

}