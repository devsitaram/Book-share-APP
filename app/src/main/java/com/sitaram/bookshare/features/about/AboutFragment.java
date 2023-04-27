package com.sitaram.bookshare.features.about;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.bookshare.R;
import com.sitaram.bookshare.features.home.HomeFragment;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AboutFragment#onCreate(Bundle)} factory method to
 * create an instance of this fragment.
 */
public class AboutFragment extends Fragment {

    Button btnBackToHome;
    View aView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return aView = inflater.inflate(R.layout.fragment_about, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnBackToHome = aView.findViewById(R.id.btnAboutToHome);
        btnBackToHome.setOnClickListener(v -> navigateHome());
    }

    private void navigateHome(){
        // go to the home fragment class
        HomeFragment homeFragment = new HomeFragment();
        @SuppressLint("UseRequireInsteadOfGet")
        FragmentTransaction fragmentTransaction = Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.flMainContener, homeFragment).addToBackStack(null).commit();
    }
}