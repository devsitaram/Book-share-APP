package com.sitaram.bookshare.features.login;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import com.sitaram.bookshare.features.database.DatabaseHelper;
import com.sitaram.bookshare.features.database.User;

import java.util.ArrayList;

import io.reactivex.rxjava3.core.Completable;

public class LoginPresenter implements LoginContract.Presenter{

    Context context;
    private final LoginContract.View view;
    private final LoginModel loginModel = new LoginModel();
    DatabaseHelper databases;
//    DatabaseHelper databases = DatabaseHelper.getInstance(this);
    // constructor
    public LoginPresenter(LoginContract.View view, Context context) {
        this.view = view;
        this.context = context;
    }

    public void onCreate(){
        databases = DatabaseHelper.getInstance(context);
    }


    // register data
    public void registerDetails(@NonNull String email, String username, String password) {

    }


    @Override
    public Completable registerButtonClick(@NonNull String email, String username, String password) {
        if (email.isEmpty()||username.isEmpty()||password.isEmpty()){
            // unsuccessful message
            view.showErrorMessage("The data is empty.");
            return null;
        } else {
            insertData(email, username, password);
            databases = DatabaseHelper.getInstance(context);
            ArrayList<User> userList = new ArrayList<>();
            userList.add(new User(email, username, password)); // add the data in the list
            Log.d("User Login Data: ", "Email: "+email+"Username: "+username+"Password: "+password);
            databases.userDao().insertUser(userList);
            return databases.userDao().insertUser(userList);
        }
    }

    public void insertData(String email, String username, String password){

    }

    public void loginButtonClick(@NonNull String username, String password) {
        if (username.isEmpty() || password.isEmpty()) {
            // call the callLoginAPI methods
            view.showErrorMessage("Email or Password is empty!");
        } else {
            callLoginDatabase(username, password);
        }
    }

    @Override
    public void callDatabase(String username, String password) {

    }

    public void callLoginDatabase(String username, String password) {
        // call the LoginModel class's method
        boolean isSuccessAPI = loginModel.callDatabase(username, password);
        if (isSuccessAPI) {
            view.loginSuccessMessage("Login successful.");
            view.navigateHomePage();
        } else {
            view.showErrorMessage("Username and password is not success.");
        }
    }

//    public Completable insertUser(@NonNull DatabaseHelper databases, String email, String username, String password) {
//        ArrayList<User> userPojoList = new ArrayList<>();
//        Log.d("User Login Data: ", databases+"Email: "+email+"Username: "+username+"Password: "+password);
//        userPojoList.add(new User(email, username, password)); // add the data in the list
//        return databases.loginDao().insertUser(userPojoList);
//    }

}
