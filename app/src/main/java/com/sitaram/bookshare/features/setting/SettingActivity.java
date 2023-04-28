package com.sitaram.bookshare.features.setting;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.example.bookshare.R;
import com.sitaram.bookshare.MainActivity;
import com.sitaram.bookshare.features.home.Books;
import com.sitaram.bookshare.features.home.HomeAdapter;

import java.util.ArrayList;
import java.util.List;

public class SettingActivity extends AppCompatActivity {

    RecyclerView sRecyclerView;
    List<SettingPojo> settingPojoList;
    Button btnBackToHome, btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        // call this setSettingRecyclerView methods and initialize the variable
        setSettingRecyclerView();
        btnBackToHome = findViewById(R.id.btnSettingToHome);
        btnLogout = findViewById(R.id.btnLogout);

        // setOnClickListener methods in btnBackToHome button
        btnBackToHome.setOnClickListener(v -> navigateHomePage());
        btnLogout.setOnClickListener(v -> setLogoutAlertDialog());
    }

    // navigate setting to home page
    private void navigateHomePage() {
        startActivity(new Intent(SettingActivity.this, MainActivity.class));
    }

    public void setSettingRecyclerView() {
        sRecyclerView = findViewById(R.id.rvUserSetting);
        settingPojoList = new ArrayList<>();
        settingPojoList.add(new SettingPojo("Edit Profile"));
        settingPojoList.add(new SettingPojo("Change Password"));
        settingPojoList.add(new SettingPojo("Change Language"));
        settingPojoList.add(new SettingPojo("Change Location"));

        // create an object of homeAdapter class and also set the hRecyclerView
        SettingAdapter settingAdapter = new SettingAdapter(this, settingPojoList);
        sRecyclerView.setAdapter(settingAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        sRecyclerView.setLayoutManager(linearLayoutManager);

        // add divider
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(sRecyclerView.getContext(), linearLayoutManager.getOrientation());
        sRecyclerView.addItemDecoration(dividerItemDecoration);
    }

    private void setLogoutAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(SettingActivity.this);
        builder.setTitle("Log out?");
        builder.setMessage("Are you sure you want to log out?");
        // press the yes the logout the app
        builder.setPositiveButton("Yes", (DialogInterface dialog, int i) -> {
            Toast.makeText(this, "Thank you", Toast.LENGTH_SHORT).show();
            finish();
        });
        // press the No then cancel to logout the app
        builder.setNegativeButton("No", (DialogInterface dialogInterface, int i) -> {
            dialogInterface.dismiss();
        });
        builder.show();
    }
}