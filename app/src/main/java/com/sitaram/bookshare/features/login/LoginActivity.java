package com.sitaram.bookshare.features.login;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sitaram.bookshare.MainActivity;
import com.example.bookshare.R;
import com.sitaram.bookshare.features.database.DatabaseHelper;

public class LoginActivity extends AppCompatActivity implements LoginContract.View {

    // create an global variable
    DatabaseHelper databases;
    Button btnLogin, btnSignUp, btnCheckBok, btnShowLogInPage, btnShowSignUpPage, btnGmail, btnFacebook, btnTwitter;
    View signUpLayout, logInLayout;
    LoginPresenter loginPresenter;
    EditText editSignUpEmail, editSignUpUsername ,editSignUpPassword, editLoginUsername, editLoginPasswords;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        databases = DatabaseHelper.getInstance(this);
        loginPresenter = new LoginPresenter( this);

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
        btnCheckBok =  findViewById(R.id.btnCheckBok);
        btnGmail = findViewById(R.id.btnLoginGmail);
        btnFacebook = findViewById(R.id.btnLoginFacebook);
        btnTwitter = findViewById(R.id.btnLoginTwitter);

        // button initialize
        btnShowLogInPage = findViewById(R.id.btnLoginLayout);
        btnShowSignUpPage = findViewById(R.id.btnSignupLayout);
        // view initialize
        signUpLayout = findViewById(R.id.signUpLayout); // logInLayout
        logInLayout = findViewById(R.id.logInLayout);

        btnShowLogInPage.setOnClickListener(v -> loginFieldsVisible());
        btnShowSignUpPage.setOnClickListener(v -> signUpFieldsVisible());

        // signup button
        btnSignUp.setOnClickListener(v -> {
            String email = editSignUpEmail.getText().toString().trim();
            String username = editSignUpUsername.getText().toString().trim();
            String password = editSignUpPassword.getText().toString().trim();
            loginPresenter.insertUser(databases, email, username, password); // call the this methods where data can be insert in the database
            loginFieldsVisible();
        });
        // login button
        btnLogin.setOnClickListener(v -> {
            String username = editLoginUsername.getText().toString().trim();
            String password = editLoginPasswords.getText().toString().trim();
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
//            loginPresenter.loginButtonClick(username, password); // call the loginButtonClick methods
        });
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    public void loginFieldsVisible(){
        btnShowSignUpPage.setTextColor(getResources().getColor(R.color.redColor, null));
        btnShowLogInPage.setBackground(getResources().getDrawable(R.drawable.switch_tricks, null));
        btnShowSignUpPage.setBackground(null);
        signUpLayout.setVisibility(View.GONE);
        logInLayout.setVisibility(View.VISIBLE);
        btnShowLogInPage.setTextColor(getResources().getColor(R.color.textColor, null));
    }
    @SuppressLint("UseCompatLoadingForDrawables")
    public void signUpFieldsVisible(){
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

    public void navigateHomePage(){
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}


















// data insert the user database
//    private Completable insertUser(String email, String username, String password) {
//        userPojoList = new ArrayList<>();
//        userPojoList.add(new UserPojo(email, username, password));
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