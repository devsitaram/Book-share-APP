package com.sitaram.bookshare.features.login;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.sitaram.bookshare.MainActivity;
import com.example.bookshare.R;
import com.sitaram.bookshare.features.database.DatabaseHelper;
import com.sitaram.bookshare.features.database.User;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class LoginActivity extends AppCompatActivity implements LoginContract.View {

    // create an global variable
    DatabaseHelper databaseHelper;
    List<User> userDataList;
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();
    Button btnLogin, btnSignUp, btnCheckBok, btnShowLogInPage, btnShowSignUpPage, btnGmail, btnFacebook, btnTwitter;
    View signUpLayout, logInLayout;
    LoginPresenter loginPresenter;
     TextInputEditText editSignUpEmail, editSignUpUsername, editSignUpPassword, editLoginUsername, editLoginPassword;
     String userEmail, userName, userPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        databaseHelper = DatabaseHelper.getInstance(this); // create an instance of database helper class
        loginPresenter = new LoginPresenter(this,this);

        // initialize the signup input textFiled
        editSignUpEmail = findViewById(R.id.inputSignUpEmail);
        editSignUpUsername = findViewById(R.id.inputSignUpUsername);
        editSignUpPassword = findViewById(R.id.inputSignUpPassword);
        // initialize the login input textFiled
        editLoginUsername = findViewById(R.id.inputLoginUsername);
        editLoginPassword = findViewById(R.id.inputLoginPasswords);

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

        btnShowLogInPage.setOnClickListener(v -> loginFieldsVisible());
        btnShowSignUpPage.setOnClickListener(v -> signUpFieldsVisible());

        // signup button
        btnSignUp.setOnClickListener(v -> Objects.requireNonNull(insertUserData()).subscribeOn(Schedulers.io())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(@NonNull Disposable disposable) {
                        compositeDisposable.add(disposable);
                    }

                    @Override
                    public void onComplete() {
                        // recycler view
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }
                }));

        // login button
        btnLogin.setOnClickListener(v -> getLogin());
    }

    // login layout visibility
    public void loginFieldsVisible() {
        btnShowSignUpPage.setTextColor(getResources().getColor(R.color.textOrange, null));
        btnShowLogInPage.setBackground(getResources().getDrawable(R.drawable.switch_tricks, null));
        btnShowSignUpPage.setBackground(null);
        signUpLayout.setVisibility(View.GONE);
        logInLayout.setVisibility(View.VISIBLE);
        btnShowLogInPage.setTextColor(getResources().getColor(R.color.textColor, null));
    }

    // signup layout visibility
    public void signUpFieldsVisible() {
        btnShowSignUpPage.setBackground(getResources().getDrawable(R.drawable.switch_tricks, null));
        btnShowSignUpPage.setTextColor(getResources().getColor(R.color.textColor, null));
        btnShowLogInPage.setBackground(null);
        logInLayout.setVisibility(View.GONE);
        signUpLayout.setVisibility(View.VISIBLE);
        btnShowLogInPage.setTextColor(getResources().getColor(R.color.textOrange, null));
    }

    @Override
    public void loginSuccessMessage(String successMessage) {
        Toast.makeText(this, successMessage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showErrorMessage(String errorMessage) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();
    }

    // email validation
    @Override
    public boolean emailValidation() {
        // get text fields text
        String emailPattern = "[a-zA-Z\\d._-]+@[a-z]+.+[a-z]+";
        // check the email validation
        if (userEmail.isEmpty()) {
            editSignUpEmail.setError("Email cannot be empty");
            return false;
        } else if (!userEmail.matches(emailPattern)) {
            editSignUpEmail.setError("Invalid email address");
            return false;
        } else {
            editSignUpEmail.setError(null);
            return true;
        }
    }

    // username validation
    @Override
    public boolean usernameValidation() {
        String usernamePattern = "[a-zA-z]+\\s+[a-zA-z]+";
        // username
        if (userName.isEmpty()) {
            editSignUpUsername.setError("Username cannot be empty");
            return false;
        } else if (!userName.matches(usernamePattern)) {
            editSignUpUsername.setError("Enter your name");
            return false;
        } else {
            editSignUpUsername.setError(null);
            return true;
        }
    }

    /**
     * create a passwordValidation methods
     * this is the boolean types of methods where is can be check the validation of password
     * check the new user data
     * // at least 1 digit
     * // at least 1 lower case letter
     * // at least 1 upper case letter
     * // at least 1 special character
     * // no white spaces
     * // at least 4 characters
     * after valid the data the return true
     * // String passwordPattern = "[a-zA-Z\\d-@#$%&]+";
     * // String passwordPattern = "(?=.*[a-zA-Z][@#$%^&+=])";
     */
    @Override
    public boolean passwordValidation(){
        if (userPassword.isEmpty()) {
            editSignUpPassword.setError("Username cannot be empty");
            return false;
        } else {
            editSignUpPassword.setError(null);
            return true;
        }
    }

    @Nullable
    public Completable insertUserData() {
        // initialize the variable
        userEmail = Objects.requireNonNull(editSignUpEmail.getText()).toString().trim();
        userName = Objects.requireNonNull(editSignUpUsername.getText()).toString().trim();
        userPassword = Objects.requireNonNull(editSignUpPassword.getText()).toString().trim();
        // call the register button click method
        boolean isSuccessRegister = loginPresenter.registerButtonClick(userEmail, userName, userPassword);
        if(isSuccessRegister) {
            loginFieldsVisible(); // after register the to visible the login contener
            loginSuccessMessage("Successful");
            return databaseHelper.userDao().insertUser(userDataList); // return the user data
        } else {
            showErrorMessage("Username and password is not match.");
            return null;
        }
    }

    @Override
    public void registerUser(String email, String username, String password) {
        userDataList = new ArrayList<>();
        userDataList.add(new User(email, username, password));
    }

    public void getLogin(){
        userName = Objects.requireNonNull(editLoginUsername.getText()).toString().trim();
        userPassword = Objects.requireNonNull(editLoginPassword.getText()).toString().trim();
        // check the username and password
        if(databaseHelper.userDao().loginDetails(userName, userPassword)){
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
        } else {
            showErrorMessage("invalid username and password.");
        }
    }

    // navigate login to home page
    public void navigateHomePage() {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

}
















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