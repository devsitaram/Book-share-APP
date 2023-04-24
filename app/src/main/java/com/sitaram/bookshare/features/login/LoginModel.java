package com.sitaram.bookshare.features.login;

public class LoginModel implements LoginContract.Model {

    @Override
    public boolean callLoginDatabase(String username, String password) {
        return true;
    }
}
