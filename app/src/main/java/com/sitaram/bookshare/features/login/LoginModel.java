package com.sitaram.bookshare.features.login;

public class LoginModel implements LoginContract.Model{

    @Override
    public boolean callDatabase(String email, String password) {
        return true;
    }
}
