package com.sitaram.bookshare.features.login;

import android.content.Context;

import com.sitaram.bookshare.features.database.User;
import com.sitaram.bookshare.features.database.UserDao;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;

public class LoginModel implements LoginContract.Model, UserDao {

    Context context;
    public LoginModel(Context context) {
        this.context = context;
    }

    /**
     * create a insertStudents methods
     * create an object of arraylist which is student class types of list
     * add the new student data where call the constructor
     * return the abstract databases class's abstract studentDao method's insertAll method which accept the student list
     */
    UserDao userDao = new UserDao() {
        @Override
        public Completable insertUser(List<User> userList) {
            return null;
        }

        @Override
        public boolean loginDetails(String nameName, String userPassword) {
            return true;
        }
    };

    @Override
    public boolean loginUser(String nameName, String userPassword) {
        return loginDetails(nameName, userPassword);
    }

    @Override
    public Completable insertUser(List<User> userList) {
        return null;
    }

    @Override
    public boolean loginDetails(String nameName, String userPassword) {
        return userDao.loginDetails(nameName,userPassword);
    }
}
