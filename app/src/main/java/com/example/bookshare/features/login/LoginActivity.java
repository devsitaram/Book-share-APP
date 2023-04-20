package com.example.bookshare.features.login;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bookshare.MainActivity;
import com.example.bookshare.R;
import com.example.bookshare.features.book.BookActivity;

public class LoginActivity extends AppCompatActivity {

    // create an global variable
    Button btnLogin, btnSignUp, btnCheckBok, showLogInPage, showSignUpPage, btnGmail, btnFacebook, btnTwitter;
    View signUpLayout, logInLayout;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // button initialization
        btnLogin = findViewById(R.id.btnLogIn);
        btnSignUp = findViewById(R.id.btnSignUp);
        btnCheckBok =  findViewById(R.id.btnCheckBok);
        btnGmail = findViewById(R.id.btnLoginGmail);
        btnFacebook = findViewById(R.id.btnLoginFacebook);
        btnTwitter = findViewById(R.id.btnLoginTwitter);

        // button initialize
        showSignUpPage = findViewById(R.id.btnSignupLayout);
        showLogInPage = findViewById(R.id.btnLoginLayout);
        // view initialize
        signUpLayout = findViewById(R.id.signUpLayout); // logInLayout
        logInLayout = findViewById(R.id.logInLayout);

        showSignUpPage.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public void onClick(View v) {
                signUpFieldsVisible();
            }
        });
        showLogInPage.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public void onClick(View v) {
                loginFieldsVisible();
            }
        });
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginFieldsVisible();
            }
        });
        // login button
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
//        btnCheckBok.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
        // login with another application
        btnGmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // go the facebook page
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.gamil.com")));
            }
        });
        btnFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // go the facebook page
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com")));
            }
        });

        btnTwitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // go the facebook page
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.twitter.com")));
            }
        });
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    public void loginFieldsVisible(){
        showSignUpPage.setTextColor(getResources().getColor(R.color.redColor, null));
        showLogInPage.setBackground(getResources().getDrawable(R.drawable.switch_tricks, null));
        showSignUpPage.setBackground(null);
        signUpLayout.setVisibility(View.GONE);
        logInLayout.setVisibility(View.VISIBLE);
        showLogInPage.setTextColor(getResources().getColor(R.color.textColor, null));
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    public void signUpFieldsVisible(){
        showSignUpPage.setBackground(getResources().getDrawable(R.drawable.switch_tricks, null));
        showSignUpPage.setTextColor(getResources().getColor(R.color.textColor, null));
        showLogInPage.setBackground(null);
        logInLayout.setVisibility(View.GONE);
        signUpLayout.setVisibility(View.VISIBLE);
        showLogInPage.setTextColor(getResources().getColor(R.color.redColor, null));
    }
}