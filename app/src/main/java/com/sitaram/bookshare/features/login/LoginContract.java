package com.sitaram.bookshare.features.login;

import com.sitaram.bookshare.features.database.User;

import io.reactivex.rxjava3.core.Single;

public interface LoginContract {

    // view interface class
    interface View {
        void loginSuccessMessage(String successMessage);
        void showErrorMessage(String errorMessage);
        void navigateHomePage();
        boolean emailValidation();
        boolean usernameValidation();
        boolean passwordValidation();
//        boolean registerUser(List<User> userList);
        void registerUser(String email, String username, String password);
    }

    // presenter interface class
    interface Presenter {
        void onCreate();
        void registerButtonClick(String email, String name, String password);
        void loginButtonClick(String username, String password);
    }

    // model interface class
    interface Model {
//        boolean setRegister(List<User> userList);
        Single<User> getLoginUser(String email, String password);
    }
}