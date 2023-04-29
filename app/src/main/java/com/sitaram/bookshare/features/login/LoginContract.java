package com.sitaram.bookshare.features.login;

import io.reactivex.rxjava3.core.Completable;

public interface LoginContract {

    // view interface class
    interface View {
        void loginSuccessMessage(String successMessage);
        void showErrorMessage(String errorMessage);
        void navigateHomePage();
        boolean emailValidation(boolean show);
    }

    // presenter interface class
    interface Presenter {
        void onCreate();
        Completable registerButtonClick(String email, String name, String password);
        void loginButtonClick(String username, String password);
        void callDatabase(String username, String password);
    }

    // model interface class
    interface Model {
        boolean callDatabase(String email, String password);
    }
}
