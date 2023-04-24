package com.sitaram.bookshare.features.login;

import android.util.Log;

import androidx.annotation.NonNull;

import com.sitaram.bookshare.features.database.DatabaseHelper;
import com.sitaram.bookshare.features.database.UserPojo;

import java.util.ArrayList;

import io.reactivex.rxjava3.core.Completable;

public class LoginPresenter implements LoginContract.Presenter {
    private final LoginContract.View view;
    private final LoginModel loginModel = new LoginModel();

    // constructor
    public LoginPresenter(LoginContract.View view) {
        this.view = view;
    }

    @Override
    public void loginButtonClick(@NonNull String username, String password) {
        if (username.isEmpty() || password.isEmpty()) {
            // call the callLoginAPI methods
            view.showErrorMessage("Email or Password is empty!");
        } else {
            callLoginDatabase(username, password);
        }
    }

    public void callLoginDatabase(String username, String password) {
        // call the LoginModel class's method
        boolean isSuccessAPI = loginModel.callLoginDatabase(username, password);
        if (isSuccessAPI) {
            view.loginSuccessMessage("Login successful.");
            view.navigateHomePage();
        } else {
            view.showErrorMessage("Username and password is not success.");
        }
    }

    public Completable insertUser(@NonNull DatabaseHelper databases, String email, String username, String password) {
        ArrayList<UserPojo> userPojoList = new ArrayList<>();
        Log.d("User Login Data: ", databases+"Email: "+email+"Username: "+username+"Password: "+password);
        userPojoList.add(new UserPojo(email, username, password)); // add the data in the list
        return databases.loginDao().insertUser(userPojoList);
    }

}
