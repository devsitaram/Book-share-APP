package com.sitaram.bookshare.features.setting;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.bookshare.R;
import com.sitaram.bookshare.MainActivity;
import com.sitaram.bookshare.features.home.Books;
import com.sitaram.bookshare.features.home.HomeAdapter;

import java.util.ArrayList;
import java.util.List;

public class SettingActivity extends AppCompatActivity {

    RecyclerView sRecyclerView;
    List<SettingPojo> settingPojoList;
    Button btnBackToHome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        btnBackToHome = findViewById(R.id.btnSettingToHome);
        setSettingRecyclerView();

        btnBackToHome.setOnClickListener(v -> navigateHomePage());

    }

    // navigate setting to home page
    private void navigateHomePage(){
        Intent intent = new Intent(SettingActivity.this, MainActivity.class);
        startActivity(intent);
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
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(sRecyclerView.getContext(),linearLayoutManager.getOrientation());
        sRecyclerView.addItemDecoration(dividerItemDecoration);
    }
}