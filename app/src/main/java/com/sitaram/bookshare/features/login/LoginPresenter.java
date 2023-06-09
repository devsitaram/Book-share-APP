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
            boolean emailValid = view.emailValidation(email);
            boolean nameValid = view.usernameValidation(username);
            boolean passwordValid = view.passwordValidation(password);
            if (emailValid && nameValid && passwordValid) {
                // call teh registerUserUser method
                view.registerUser(email, username, password);
                return true;
            } else {
                return false;
            }
        }
    }

    @Override
    public boolean loginButtonClick(String username, String password) {
        if (username.isEmpty() || password.isEmpty()) {
            // call the callLoginAPI methods
            view.showErrorMessage("The field is empty!");
            return false;
        } else {
            return view.login(username,password);
//            return callLoginDatabase(username, password); // this  method can return the true or false values
        }
    }

    public boolean callLoginDatabase(String username, String password) {
        // call the LoginModel class's method
        boolean isSuccessAPI = loginModel.loginUser(username, password);
        if (isSuccessAPI) {
            view.loginSuccessMessage("Login successful.");
            return true;
        } else {
            view.showErrorMessage("Username and password is not registered.");
            return false;
        }
    }
}
