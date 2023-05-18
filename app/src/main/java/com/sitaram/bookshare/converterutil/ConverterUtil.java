package com.sitaram.bookshare.converterutil;

import androidx.annotation.NonNull;

public class ConverterUtil {

    // check the email validation
    @NonNull
    public static String emailValidation(String email) {
        String emailPattern = "[a-zA-Z\\d._-]+@[a-z]+.+[a-z]+";
        if (email.isEmpty()) {
            return "The field is empty";
        } else if (!email.matches(emailPattern)) {
            return "Doesn't match";
        } else {
            return email;
        }
    }

    // to check the username validation
    @NonNull
    public static String usernameValidation(String name) {
        String usernamePattern = "[a-zA-z]+\\s+[a-zA-z]+";
        if (name.isEmpty()) {
            return "Username cannot be empty";
        } else if (!name.matches(usernamePattern)) {
            return "Enter your name";
        } else {
            return name;
        }
    }

    // password check the  empty or not
    @NonNull
    public static String passwordValidation(String password){
        if (password.isEmpty()) {
            return "Username cannot be empty";
        } else {
            return password;
        }
    }
}
