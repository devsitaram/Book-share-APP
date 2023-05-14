package com.sitaram.bookshare.features.login;

public interface LoginContract {

    // view interface class
    interface View {
        void loginSuccessMessage(String successMessage);
        void showErrorMessage(String errorMessage);
        void navigateHomePage();

        // email validation
        boolean emailValidation(String email);
        boolean usernameValidation(String name);
        boolean passwordValidation(String password);
        void registerUser(String email, String username, String password);
    }

    // presenter interface class
    interface Presenter {
        boolean registerButtonClick(String email, String name, String password);
        void loginButtonClick(String username, String password);
    }

    // model interface class
    interface Model {}
}