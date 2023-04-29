package com.sitaram.bookshare.features.login;

import android.content.Context;

public class LoginModel implements LoginContract.Model{

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
//        try {
//            databaseHelper = DatabaseHelper.getInstance(context);
//            databaseHelper.userDao().insertUser(userList);
//            return true;
//        } catch (Exception ex) {
//            return false;
//        }


//    @Override
//    public Single<User> getLoginUser(String nameName, String userPassword) {
////        return userDao.getLoginDetails(nameName, userPassword);
//        return null;
//    }
}
