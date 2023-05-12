package com.sitaram.bookshare.features.product;

import android.annotation.SuppressLint;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.example.bookshare.R;
import com.sitaram.bookshare.features.product.helper.BookPojo;
import com.google.android.material.tabs.TabLayout;
import com.sitaram.bookshare.features.home.HomeFragment;
import com.sitaram.bookshare.features.product.firstviewpager.ForYouBookFragment;
import com.sitaram.bookshare.features.product.secondviewpager.TrendingBookFragment;

public class ProductFragment extends Fragment implements ProductContract.View {

    EditText editSearchText;
    Button btnBackToHome, btnGoogleSearch;
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
        // set the view pager adapter in view pager
        viewPager.setAdapter(viewPagerAdapter);
        return bookView;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstenceState) {
        super.onViewCreated(view, savedInstenceState);

        // innitialize the variable
        editSearchText = bookView.findViewById(R.id.editBookSearch);
        btnBackToHome = bookView.findViewById(R.id.btnBackToHome);
        btnGoogleSearch = bookView.findViewById(R.id.btnGoogleSearchBook);

        // go to home page
        btnBackToHome.setOnClickListener(v -> {
            goBackHome(); //call this methods
        });

        // book search by google
        btnGoogleSearch.setOnClickListener(v -> {
            String searchText = editSearchText.getText().toString().trim();
            bookFromSearch(searchText);
        });
    }

    @Override
    public void setBooks(BookPojo body) {}

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

    // go back to home page
    public void goBackHome() {
        // go to the home fragment class
        HomeFragment homeFragment = new HomeFragment();
        FragmentTransaction fragmentTransaction = requireActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.flMainContener, homeFragment).addToBackStack(null).commit();
    }

    // google search
    public void bookFromSearch(String searchText) {
        try {
            Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
            intent.putExtra(SearchManager.QUERY, searchText);
            startActivity(intent);
        } catch (Exception ex) {
            ex.printStackTrace();
            bookFromSearch(searchText); // recall the methods
        }
    }
}