package com.sitaram.bookshare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bookshare.R;
import com.sitaram.bookshare.features.about.AboutFragment;
import com.sitaram.bookshare.features.contact.ContactFragment;
import com.sitaram.bookshare.features.book.BookFragment;
import com.sitaram.bookshare.features.home.HomeFragment;
import com.sitaram.bookshare.features.profile.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    EditText editText_search;
    Button btnNotification;
    ImageView ivUserProfile;
    TextView tvNavbarForYou, tvNavbarTopChart, tvNavbarChildren, tvNavbarPremium, tvNavbarCategory;

    @SuppressLint({"NotifyDataSetChanged", "MissingInflatedId", "ClickableViewAccessibility"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialize the object
        @SuppressLint("CutPasteId")
        BottomNavigationView bottomNavigationView = findViewById(R.id.btnNavicationIcon);
        HomeFragment homeFragment = new HomeFragment();
        ProfileFragment profileFragment = new ProfileFragment();
        BookFragment bookFragment = new BookFragment();
        ContactFragment contactFragment = new ContactFragment();
        AboutFragment aboutFragment = new AboutFragment();

//        // variable initialize
//        editText_search = findViewById(R.id.editText_search);
//        btnNotification = findViewById(R.id.btn_notification);
//        ivUserProfile = findViewById(R.id.img_userProfile);

        // already show the apps fragment class
        getSupportFragmentManager().beginTransaction().replace(R.id.flMainContener, homeFragment).commit();
        // this is the bottomNavigationView where click to go the button related pages
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navBtnHome:
                        // go to the home fragment class
                        getSupportFragmentManager().beginTransaction().replace(R.id.flMainContener, homeFragment).commit();
                        return true;
                    case R.id.navBtnProfile:
                        // go to the profile fragment class
                        getSupportFragmentManager().beginTransaction().replace(R.id.flMainContener, profileFragment).commit();
                        return true;
                    case R.id.navBtnProduct:
                        // go to the product fragment class
                        getSupportFragmentManager().beginTransaction().replace(R.id.flMainContener, bookFragment).commit();
                        return true;
                    case R.id.navBtnContact:
                        // go to the contract fragment class
                        getSupportFragmentManager().beginTransaction().replace(R.id.flMainContener, contactFragment).commit();
                        return true;
                    case R.id.navBtnAbout:
                        // go to the about fragment class
                        getSupportFragmentManager().beginTransaction().replace(R.id.flMainContener, aboutFragment).commit();
                        return true;
                    default:
                        return false;
                }
            }
        });

        // edit text fields
//        editText_search.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View view, MotionEvent event) {
//                view.setFocusable(true);
//                view.setFocusableInTouchMode(true);
//                return false;
//            }
//        });
        // notification button
//        btnNotification.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
//                builder.setTitle("Notification");
//                builder.setMessage("No new notifications");
//                // press the yes the logout the app
//                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int i) {
//                        toastMassage("Thank you");
//                    }
//                });
//                // press the No then cancel to logout the app
//                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        dialogInterface.dismiss();
//                    }
//                });
//                builder.show();
//            }
//        });
        // contact class
//        ivUserProfile.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                getSupportFragmentManager().beginTransaction().replace(R.id.fl_mainContener, contactsFragment).commit();
//            }
//        });
    }

    // create a toastMassage method which accept the String parameter
    public void toastMassage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}