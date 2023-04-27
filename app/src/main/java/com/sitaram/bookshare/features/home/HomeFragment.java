package com.sitaram.bookshare.features.home;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bookshare.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.sitaram.bookshare.features.about.AboutFragment;
import com.sitaram.bookshare.features.contact.ContactFragment;
import com.sitaram.bookshare.features.menu.MenuActivity;
import com.sitaram.bookshare.features.menu.MenuFragment;
import com.sitaram.bookshare.features.product.ProductFragment;
import com.sitaram.bookshare.features.profile.ProfileFragment;

import java.util.ArrayList;

public class HomeFragment extends Fragment{

    // initialize the global variable
    RecyclerView hRecyclerView;
    Button btnSettingMenu, btnNotification;
    EditText editTextSearch;
    ArrayList<Books> arrBooksList;
    MenuFragment menuFragment = new MenuFragment();
    BottomNavigationView bottomNavigationView;
    FragmentTransaction fragmentTransaction;
    View hView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return hView = inflater.inflate(R.layout.fragment_home, container, false);
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setBookRecyclerView(); // call this methods

        // initialize the class and create an object
        HomeFragment homeFragment = new HomeFragment();
        ProfileFragment profileFragment = new ProfileFragment();
        ProductFragment productFragment = new ProductFragment();
        ContactFragment contactFragment = new ContactFragment();
        AboutFragment aboutFragment = new AboutFragment();

        // initialization the variable
        editTextSearch = hView.findViewById(R.id.editTextSearch);
        btnNotification = hView.findViewById(R.id.btnNotification);
        btnSettingMenu = hView.findViewById(R.id.btnSettingMenu);

        // setting menu button
        btnSettingMenu.setOnClickListener(v -> {navigateMenu();});

        // notification button
        btnNotification.setOnClickListener(view1 -> {
            setNotificationMessage(); // call this methods
        });

        // edit text fields
        editTextSearch.setOnTouchListener((viewText, event) -> {
            setEditTextSearch(viewText);
            return false;
        });

        bottomNavigationView = hView.findViewById(R.id.btnNavicationIcon);
        // this is the bottomNavigationView where click to go the button related pages
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                switch (item.getItemId()) {
                    case R.id.navBtnHome:
                        // go to the home fragment class
                        fragmentTransaction.replace(R.id.flMainContener, homeFragment);
                        fragmentTransaction.addToBackStack(null).commit();
                        return true;
                    case R.id.navBtnProfile:
                        // go to the profile fragment class
                        fragmentTransaction.replace(R.id.flMainContener, profileFragment);
                        fragmentTransaction.addToBackStack(null).commit();
                        return true;
                    case R.id.navBtnProduct:
                        // go to the product fragment class
                        fragmentTransaction.replace(R.id.flMainContener, productFragment);
                        fragmentTransaction.addToBackStack(null).commit();
                        return true;
                    case R.id.navBtnContact:
                        // go to the contract fragment class
                        fragmentTransaction.replace(R.id.flMainContener, contactFragment);
                        fragmentTransaction.addToBackStack(null).commit();
                        return true;
                    case R.id.navBtnAbout:
                        // go to the about fragment class
                        fragmentTransaction.replace(R.id.flMainContener, aboutFragment);
                        fragmentTransaction.addToBackStack(null).commit();
                        return true;
                    default:
                        return false;
                }
            }
        });
    }

    public void setBookRecyclerView() {
        hRecyclerView = hView.findViewById(R.id.rvHomeBookItem);

        arrBooksList = new ArrayList<>();
        arrBooksList.add(new Books(R.mipmap.book_app_logo,"Hello"));
        arrBooksList.add(new Books(R.mipmap.book_app_logo,"Hello"));
        arrBooksList.add(new Books(R.mipmap.book_app_logo,"Hello"));
        arrBooksList.add(new Books(R.mipmap.book_app_logo,"Hello"));

        // create an object of homeAdapter class and also set the hRecyclerView
        HomeAdapter homeAdapter = new HomeAdapter(getActivity(),arrBooksList);
        hRecyclerView.setAdapter(homeAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL, false);
        hRecyclerView.setLayoutManager(linearLayoutManager);
    }

    // notification button
    private void setNotificationMessage(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Notification");
        builder.setMessage("No new notifications");
        // press the yes the logout the app
        builder.setPositiveButton("Ok", (dialog, i) -> {
            toastMassage("Thank you");// call the toast message
        });
        // press the No then cancel to logout the app
        builder.setNegativeButton("Cancel", (DialogInterface dialogInterface, int i) -> {
            dialogInterface.dismiss();
        });
        builder.show();
    }

    public void navigateMenu(){
        Intent intent = new Intent(getActivity(), MenuActivity.class);
        startActivity(intent);
//        FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
//        // go to the home fragment class
//        fragmentTransaction.replace(R.id.flMenuContener, menuFragment).commit();
    }

    // create a toastMassage method which accept the String parameter
    public void toastMassage(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    // text fields setFocusable control
    private void setEditTextSearch(@NonNull View viewText){
        viewText.setFocusable(true);
        viewText.setFocusableInTouchMode(true);
    }
}


//
//    public void setRecyclerView(){
//        recyclerView = hView.findViewById(R.id.rvHomeBookItem);
//        BooksItem booksItem = new BooksItem();
//        arrBookItemList = new ArrayList<>();
//
////        ArrayList<BooksItem> arrBookList = new ArrayList<>();
////        arrBookList.add(booksItem.getUrl());
////        arrBookList.add(booksItem.getTitle());
//
//
////        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
////        recyclerView.setLayoutManager(linearLayoutManager);
////        HomeAdapter homeAdapter = new HomeAdapter(getActivity(), arrBookList);
////        recyclerView.setAdapter(homeAdapter);
//    }