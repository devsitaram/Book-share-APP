package com.sitaram.bookshare.features.login;

import android.content.Context;

import androidx.annotation.NonNull;

import com.sitaram.bookshare.features.database.User;

import java.util.List;

public class LoginPresenter implements LoginContract.Presenter{

    Context context;
    private final LoginContract.View view;
    List<User> userList;
    LoginModel loginModel;
    public LoginPresenter(LoginContract.View view, Context context) {
        this.view = view;
        this.context = context;
    }

    @Override
    public boolean registerButtonClick(@NonNull String email, String username, String password) {
        if (email.isEmpty() && username.isEmpty() && password.isEmpty()){
            view.showErrorMessage("The fields is empty!"); // unsuccessful message
            return false;
        } else {
            if (view.emailValidation(email) && view.usernameValidation(username) && view.passwordValidation(password)) {
                // call teh registerUserUser method
                view.registerUser(email, username, password);
                return true;
            } else {
                return false;
            }
        }
    }

    @Override
    public void loginButtonClick(String username, String password) {
        if (username.isEmpty() || password.isEmpty()) {
            // call the callLoginAPI methods
            view.showErrorMessage("The field is empty!");
        } else {
            callLoginDatabase(username, password);
        }
    }

    public void callLoginDatabase(String username, String password) {
        // call the LoginModel class's method
//        boolean isSuccessAPI = loginModel.getUser(username, password);
//        if (isSuccessAPI) {
//            view.loginSuccessMessage("Login successful.");
//            view.navigateHomePage();
//        } else {
//            view.showErrorMessage("Username and password is not registered.");
//        }
    }
}
