package com.sitaram.bookshare.testing;

public class ConverterUtil {

    // check the email validation
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

    public static String passwordValidation(String password){
        if (password.isEmpty()) {
            return "Username cannot be empty";
        } else {
            return password;
        }
    }
}
