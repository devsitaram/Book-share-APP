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

    public void onCreate(){}

    @Override
    public void registerButtonClick(@NonNull String email, String username, String password) {
        if (email.isEmpty() && username.isEmpty() && password.isEmpty()){
            view.showErrorMessage("The fields is empty!"); // unsuccessful message
        } else {
            boolean validEmail = view.emailValidation();
            boolean validName = view.usernameValidation();
            boolean validPassword = view.passwordValidation();
            if (validEmail && validName && validPassword) {
                // call teh registerUserUser method
                view.registerUser(email, username, password);
            }
        }
    }

    // insert new data
//    public void registerUserDetails(String email, String username, String password){
//            view.loginSuccessMessage("Register successful.");
//            view.registerUser(email, username, password);
//    }
//    public void registerUsers(List<User> userList){
//        loginModel = new LoginModel(context);
//        userList = new ArrayList<>();
//        userList.add(new User(email, username, password));
//        boolean isSuccess = loginModel.setRegister(userList);
//        if (isSuccess){
//            view.loginSuccessMessage("Register successful.");
//            view.registerUser(email, username, password);
//        } else {
//            view.showErrorMessage("The field is empty!");
//        }
//    }

    public void loginButtonClick(@NonNull String username, String password) {
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

//    public Completable insertUser(@NonNull DatabaseHelper databases, String email, String username, String password) {
//        ArrayList<User> userPojoList = new ArrayList<>();
//        Log.d("User Login Data: ", databases+"Email: "+email+"Username: "+username+"Password: "+password);
//        userPojoList.add(new User(email, username, password)); // add the data in the list
//        return databases.loginDao().insertUser(userPojoList);
//    }

}
