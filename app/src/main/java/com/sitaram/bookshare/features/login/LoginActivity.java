package com.sitaram.bookshare.features.login;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.sitaram.bookshare.MainActivity;
import com.example.bookshare.R;
import com.sitaram.bookshare.features.database.DatabaseHelper;
import com.sitaram.bookshare.features.database.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class LoginActivity extends AppCompatActivity implements LoginContract.View {

    // create an global variable
    DatabaseHelper databases;
    List<User> userDataList;
    Button btnLogin, btnSignUp, btnCheckBok, btnShowLogInPage, btnShowSignUpPage, btnGmail, btnFacebook, btnTwitter;
    View signUpLayout, logInLayout;
    LoginPresenter loginPresenter;
    TextInputEditText editSignUpEmail, editSignUpUsername, editSignUpPassword, editLoginUsername, editLoginPasswords;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        databases = DatabaseHelper.getInstance(this);
        loginPresenter = new LoginPresenter(this, this);

        // initialize the signup input textFiled
        editSignUpEmail = findViewById(R.id.inputSignUpEmail);
        editSignUpUsername = findViewById(R.id.inputSignUpUsername);
        editSignUpPassword = findViewById(R.id.inputSignUpPassword);
        // initialize the login input textFiled
        editLoginUsername = findViewById(R.id.inputLoginUsername);
        editLoginPasswords = findViewById(R.id.inputLoginPasswords);

        // button initialization
        btnLogin = findViewById(R.id.btnLogIn); // login botton
        btnSignUp = findViewById(R.id.btnSignUp); // sign up botton
        btnCheckBok = findViewById(R.id.btnCheckBok);
        btnGmail = findViewById(R.id.btnLoginGmail);
        btnFacebook = findViewById(R.id.btnLoginFacebook);
        btnTwitter = findViewById(R.id.btnLoginTwitter);

        // button initialize
        btnShowLogInPage = findViewById(R.id.btnLoginLayout);
        btnShowSignUpPage = findViewById(R.id.btnSignupLayout);
        // view initialize
        signUpLayout = findViewById(R.id.signUpLayout); // logInLayout
        logInLayout = findViewById(R.id.logInLayout);

        // get text fields text
        String email = Objects.requireNonNull(editSignUpEmail.getText()).toString().trim();
        String username = Objects.requireNonNull(editSignUpUsername.getText()).toString().trim();
        String password = Objects.requireNonNull(editSignUpPassword.getText()).toString().trim();

        btnShowLogInPage.setOnClickListener(v -> loginFieldsVisible());
        btnShowSignUpPage.setOnClickListener(v -> signUpFieldsVisible());

        // signup button
        btnSignUp.setOnClickListener(v -> {
            if (emailValidation(true)){
//            loginPresenter.insertUser(databases, email, username, password); // call the this methods where data can be insert in the database
                loginFieldsVisible();
            }
        });

        // login button
        btnLogin.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
//            setRecyclerView(username, password);
//            loginPresenter.loginButtonClick(username, password); // call the loginButtonClick methods
        });
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    public void loginFieldsVisible() {
        btnShowSignUpPage.setTextColor(getResources().getColor(R.color.redColor, null));
        btnShowLogInPage.setBackground(getResources().getDrawable(R.drawable.switch_tricks, null));
        btnShowSignUpPage.setBackground(null);
        signUpLayout.setVisibility(View.GONE);
        logInLayout.setVisibility(View.VISIBLE);
        btnShowLogInPage.setTextColor(getResources().getColor(R.color.textColor, null));
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    public void signUpFieldsVisible() {
        btnShowSignUpPage.setBackground(getResources().getDrawable(R.drawable.switch_tricks, null));
        btnShowSignUpPage.setTextColor(getResources().getColor(R.color.textColor, null));
        btnShowLogInPage.setBackground(null);
        logInLayout.setVisibility(View.GONE);
        signUpLayout.setVisibility(View.VISIBLE);
        btnShowLogInPage.setTextColor(getResources().getColor(R.color.redColor, null));
    }

    @Override
    public void loginSuccessMessage(String successMessage) {
        Toast.makeText(this, successMessage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showErrorMessage(String errorMessage) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();
    }

    public void navigateHomePage() {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public boolean emailValidation(boolean show) {
        String email = Objects.requireNonNull(editSignUpEmail.getText()).toString().trim();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+.+[a-z]+";
        String noWhiteSpace = "\\A\\w{1,30}\\z";
        // check the email validation
        if (email.isEmpty()) {
            editSignUpEmail.setError("Field cannot be empty");
            return false;
        } else if (!email.matches(emailPattern)) {
            editSignUpEmail.setError("Invalid email address");
            return false;
        } else if (!email.matches(noWhiteSpace)) {
            editSignUpEmail.setError("White spaces are not allowed");
            return false;
        } else {
            editSignUpEmail.setError(null);
            editSignUpEmail.setEnabled(false);
            return true;
        }
    }

    /**
     * create a registerUser methods
     * create an object of arraylist which is userPojo class types of list
     * add the new user data where call the constructor
     * return the abstract databases class's abstract UserDao method's insertUser method which accept the user data's list
     */
    private Completable registerUser(String email, String name, String password) {
        userDataList = new ArrayList<>();
        userDataList.add(new User(email, name, password));
        return databases.userDao().insertUser(userDataList);
    }
}










// data insert the user database
//    private Completable insertUser(String email, String username, String password) {
//        userPojoList = new ArrayList<>();
//        userPojoList.add(new User(email, username, password));
//        return databases.loginDao().insertUser(userPojoList);
//    }


// login with another application
//        btnGmail.setOnClickListener(new View.OnClickListener() {
//@Override
//public void onClick(View view) {
//        // go the facebook page
//        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.gamil.com")));
//        }
//        });
//        btnFacebook.setOnClickListener(new View.OnClickListener() {
//@Override
//public void onClick(View view) {
//        // go the facebook page
//        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com")));
//        }
//        });
//        btnTwitter.setOnClickListener(new View.OnClickListener() {
//@Override
//public void onClick(View view) {
//        // go the facebook page
//        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.twitter.com")));
//        }
//        });