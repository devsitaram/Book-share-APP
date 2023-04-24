package com.sitaram.bookshare.features.login;

public interface LoginContract {

    // view interface class
    interface View {
        void loginSuccessMessage(String successMessage);

        void showErrorMessage(String errorMessage);
        void navigateHomePage();
    }

    // presenter interface class
    interface Presenter {
        void loginButtonClick(String username, String password);

        void callLoginDatabase(String username, String password);


    }

    // model interface class
    interface Model {
        boolean callLoginDatabase(String email, String password);
    }
}
