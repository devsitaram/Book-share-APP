package com.example.bookshare.features.login;

import com.example.bookshare.features.database.Dao;

public class LoginModel implements LoginContract.Model {

    @Override
    public boolean callLoginDatabase(String username, String password) {
        return true;
    }
}
