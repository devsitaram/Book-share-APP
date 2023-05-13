package com.sitaram.bookshare;

import static org.junit.Assert.assertEquals;

import com.sitaram.bookshare.testing.ConverterUtil;

import org.junit.Test;

public class RegisterTestUtil {

    // user details are validation testing
    @Test
    public void registerUser(){
        assertEquals("Email: ", "sitaram123@gmail.com", ConverterUtil.emailValidation("sitaram123@gmail.com"));

        assertEquals("User name: ", "sitaram Thing", ConverterUtil.usernameValidation("sitaram Thing"));

        assertEquals("Password: ", "@sitaram123", ConverterUtil.passwordValidation("@sitaram123"));
    }

}
