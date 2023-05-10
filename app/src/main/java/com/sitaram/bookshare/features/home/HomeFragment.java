package com.sitaram.bookshare.features.home;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.SearchManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookshare.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.sitaram.bookshare.features.about.AboutFragment;
import com.sitaram.bookshare.features.contact.ContactFragment;
import com.sitaram.bookshare.features.menu.MenuActivity;
import com.sitaram.bookshare.features.product.ProductFragment;
import com.sitaram.bookshare.features.profile.ProfileFragment;

import java.util.ArrayList;
import java.util.Objects;

public class HomeFragment extends Fragment implements HomeContract.View {

    // initialize the global variable
    RecyclerView hRecyclerView;
    Button btnGoogleSearchBook, btnMenuItems, btnNotification;
    ImageView ivUserProfile;
    EditText editTextSearch;
    ArrayList<Books> arrBooksList;
    BottomNavigationView bottomNavigationView;
    FragmentTransaction fragmentTransaction;
    View hView;

    HomePresenter homePresenter = new HomePresenter(this);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return hView = inflater.inflate(R.layout.fragment_home, container, false);
    }

    @SuppressLint({"ClickableViewAccessibility", "NonConstantResourceId", "UseRequireInsteadOfGet"})
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
        btnGoogleSearchBook = hView.findViewById(R.id.btnGoogleSearchBook);
        btnNotification = hView.findViewById(R.id.btnNotification);
        ivUserProfile = hView.findViewById(R.id.ivUserProfile);
        btnMenuItems = hView.findViewById(R.id.btnSettingMenu);
        bottomNavigationView = hView.findViewById(R.id.btnNavicationIcon);

        // setting menu button
        btnMenuItems.setOnClickListener(v -> navigateMenu());

        // notification button
        btnNotification.setOnClickListener(view1 -> {
            setNotificationMessage(); // call this methods
        });

        // user profile
        ivUserProfile.setOnClickListener(v -> {
            // go to the profile fragment class
            FragmentTransaction fragmentTransaction = requireActivity().getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.flMainContener, profileFragment).addToBackStack(null).commit();
        });

        // edit text fields
        editTextSearch.setOnTouchListener((View viewText, MotionEvent event) -> {
            setEditTextSearch(viewText);
            return false;
        });

        // google search
        btnGoogleSearchBook.setOnClickListener(v -> {
            String searchText = editTextSearch.getText().toString();
            homePresenter.getGoogleSearch(searchText);
        });

        // this is the bottomNavigationView where click to go the button related pages
        bottomNavigationView.setOnItemSelectedListener(item -> {
            fragmentTransaction = Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction();
            switch (item.getItemId()) {
                case R.id.navBtnHome:
                    // go to the home fragment class
                    fragmentTransaction.replace(R.id.flMainContener, homeFragment).addToBackStack(null).commit();
                    return true;
                case R.id.navBtnProfile:
                    // go to the profile fragment class
                    fragmentTransaction.replace(R.id.flMainContener, profileFragment).addToBackStack(null).commit();
                    return true;
                case R.id.navBtnProduct:
                    // go to the product fragment class
                    fragmentTransaction.replace(R.id.flMainContener, productFragment).addToBackStack(null).commit();
                    return true;
                case R.id.navBtnContact:
                    // go to the contract fragment class
                    fragmentTransaction.replace(R.id.flMainContener, contactFragment).addToBackStack(null).commit();
                    return true;
                case R.id.navBtnAbout:
                    // go to the about fragment class
                    fragmentTransaction.replace(R.id.flMainContener, aboutFragment).addToBackStack(null).commit();
//                    fragmentTransaction.addToBackStack(null).commit();
                    return true;
                default:
                    return false;
            }
        });
    }

    // navigateMenu
    public void navigateMenu() {
        startActivity(new Intent(getActivity(), MenuActivity.class));
    }

    // text fields setFocusable control
    private void setEditTextSearch(@NonNull View viewText) {
        viewText.setFocusable(true);
        viewText.setFocusableInTouchMode(true);
    }

    // google search
    public void googleSearch(String searchText) {
        try {
            Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
            intent.putExtra(SearchManager.QUERY, searchText);
            startActivity(intent);
        } catch (Exception ex) {
            ex.printStackTrace();
            googleSearch(searchText); // recall the methods
        }
    }

    // set recycler view
    public void setBookRecyclerView() {
        hRecyclerView = hView.findViewById(R.id.rvHomeBookItem);

        arrBooksList = new ArrayList<>();
        arrBooksList.add(new Books(R.mipmap.book_app_logo, "Hello"));
        arrBooksList.add(new Books(R.mipmap.book_app_logo, "Hello"));
        arrBooksList.add(new Books(R.mipmap.book_app_logo, "Hello"));
        arrBooksList.add(new Books(R.mipmap.book_app_logo, "Hello"));

        // create an object of homeAdapter class and also set the hRecyclerView
        HomeAdapter homeAdapter = new HomeAdapter(getActivity(), arrBooksList);
        hRecyclerView.setAdapter(homeAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        hRecyclerView.setLayoutManager(linearLayoutManager);
    }

    @Override
    public void successMessage(String success) {
        toastMassage(success);
    }

    @Override
    public void errorMessage(String error) {
        toastMassage(error);
    }

    // create a toastMassage method which accept the String parameter
    public void toastMassage(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    // notification button
    private void setNotificationMessage() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Notification");
        builder.setMessage("No new notifications");
        // press the yes the logout the app
        builder.setPositiveButton("Ok", (dialog, i) -> {
            toastMassage("Thank you");// call the toast message
        });
        // press the No then cancel to logout the app
        builder.setNegativeButton("Cancel", (DialogInterface dialogInterface, int i) -> dialogInterface.dismiss());
        builder.show();
    }
}
